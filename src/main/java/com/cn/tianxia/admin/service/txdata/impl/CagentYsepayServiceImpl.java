package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentYsepayMapper;
import com.cn.tianxia.admin.project.txdata.CagentYsepay;
import com.cn.tianxia.admin.service.txdata.CagentYsepayService;

@Service
public class CagentYsepayServiceImpl implements CagentYsepayService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentYsepayServiceImpl.class);
    
    @Autowired
    private CagentYsepayMapper cagentYsepayMapper;
    /**
     * 
     * @Description 删除单条二维码配置信息
     * @return
     */
    @Override
    public int delete(Integer id) {
        return cagentYsepayMapper.deleteByPrimaryKey(id);
    }
    /**
     * 
     * @Description 添加单条二维码配置信息
     * @return
     */
    @Override
    public int add(CagentYsepay record) {
        return cagentYsepayMapper.insertSelective(record);
    }
    /**
     * 
     * @Description 查看单条在线支付配置信息
     * @return
     */
    @Override
    public CagentYsepay info(Integer id) {
        return cagentYsepayMapper.selectByPrimaryKey(id);
    }
    /**
     * 
     * @Description 修改在线支付配置信息
     * @return
     */
    @Override
    public int update(CagentYsepay record) {
        return cagentYsepayMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 
     * @Description 查看在线支付配置列表信息
     * @return
     */
    @Override
    public Pager<CagentYsepay> list(Map<String, String> params) {
        Pager<CagentYsepay> pager = new Pager<CagentYsepay>();
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey("page")){
                pager.setPage(Integer.parseInt(params.remove("page")));
            }
            if(params.containsKey("limit")){
                pager.setLimit(Integer.parseInt(params.remove("limit")));
            }
        }
        pager.setParams(params);
        //根据条件查询在线支付配置列表
        List<CagentYsepay> cagentYsepays = cagentYsepayMapper.findAllByPage(pager);
        //根据条件查询在线支付配置总条数
        int totalCounts = cagentYsepayMapper.getCagentYsepayTotalCounts(pager);
        //总条数
        Pager<CagentYsepay> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(cagentYsepays);
        return result;
    }

}
