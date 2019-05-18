package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentMapper;
import com.cn.tianxia.admin.domain.txdata.CagentMsgconfigMapper;
import com.cn.tianxia.admin.domain.txdata.SysUserMapper;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.project.txdata.SysUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.project.txdata.CagentMsgconfig;
import com.cn.tianxia.admin.service.txdata.CagentMsgconfigService;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName CagentMsgconfigServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:36:02
 * @version 1.0.0
 */
@Service
public class CagentMsgconfigServiceImpl implements CagentMsgconfigService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentMsgconfigServiceImpl.class);
    
    @Autowired
    private CagentMsgconfigMapper cagentMsgconfigMapper;

    @Autowired
    private CagentMapper cagentMapper;

    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentMsgconfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentMsgconfig record) {
        return cagentMsgconfigMapper.insertSelective(record);
    }

    @Override
    public CagentMsgconfig selectByPrimaryKey(Integer id) {
        return cagentMsgconfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentMsgconfig record) {
        return cagentMsgconfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<CagentMsgconfig> findAllByCid(Map<String, String> params) throws Exception {
        logger.info("查询短信平台配置信息参数：{}",params);
        Pager<CagentMsgconfig> pager = new Pager<>();
        if (!CollectionUtils.isEmpty(params)) {
            if (params.containsKey(Constant.PAGE_FILED)) {
                pager.setPage(Integer.parseInt(params.remove(Constant.PAGE_FILED)));
            }
            if (params.containsKey(Constant.LIMIT_FILED)) {
                pager.setLimit(Integer.parseInt(params.remove(Constant.LIMIT_FILED)));
            }
        }
        pager.setParams(params);
        List<CagentMsgconfig> cagentMsgconfigList = new ArrayList<>();
        List<CagentMsgconfig> cagentMsgconfigs = cagentMsgconfigMapper.findAllByCid(pager);
        cagentMsgconfigs.stream().forEach(item ->{
            // 通过平台id查看平台商名称
            Cagent cagent = cagentMapper.selectByPrimaryKey(item.getCid());
            item.setCagentName(cagent.getCagent());
            //通过用户id拿到更新人名字
            SysUser user = sysUserMapper.selectByPrimaryKey(Long.parseLong(item.getUpsn()));
            item.setUpName(user.getLoginName());
            cagentMsgconfigList.add(item);
        });
        int totalCount = cagentMsgconfigMapper.getTotalCount(pager);
        Pager<CagentMsgconfig> result = new Pager<>(totalCount,pager.getPage(),pager.getLimit());
        result.setList(cagentMsgconfigList);
        return result;
    }

    @Override
    public int insertJudgeStatus(CagentMsgconfig record) {
        if("0".equals(record.getStatus())){
            // 当新增的短信平台配置为启用时，把该平台商下的其它短信平台配置设置为停用，即只启用新增加的
            cagentMsgconfigMapper.updateStatus(record.getCid());
        }else {
            //当新增的短信平台配置为停用时，需判断该平台商下有无其它短信平台配置信息，如果有则允许添加，无则代表首次添加必须为启用
            Pager<CagentMsgconfig> pager = new Pager<>();
            Map<String,String> map = new HashMap<>();
            map.put("cid",record.getCid().toString());
            pager.setParams(map);
            List<CagentMsgconfig> cagentMsgconfigs = cagentMsgconfigMapper.findAllByCid(pager);
            if(cagentMsgconfigs.size() == 0){
                return 1;
            }
        }
        cagentMsgconfigMapper.insertSelective(record);
        return 0;
    }

    @Override
    public int updateJudgeStatus(CagentMsgconfig record) {
        CagentMsgconfig oldRecord = cagentMsgconfigMapper.selectByPrimaryKey(record.getId());
        record.setCid(oldRecord.getCid());
        if("0".equals(record.getStatus())){
            // 当更新的短信平台配置为启用时，把该平台商下的其它短信平台配置设置为停用
            cagentMsgconfigMapper.updateStatus(oldRecord.getCid());
        }else if("1".equals(record.getStatus()) && "0".equals(oldRecord.getStatus())){
            return 1 ;
        }
        cagentMsgconfigMapper.updateByPrimaryKey(record);
        return 0;
    }

}
