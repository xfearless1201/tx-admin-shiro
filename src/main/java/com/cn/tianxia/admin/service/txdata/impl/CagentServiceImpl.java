package com.cn.tianxia.admin.service.txdata.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentMapper;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.service.txdata.CagentService;

/**
 * 
 * @ClassName CagentServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:13:59
 * @version 1.0.0
 */
@Service
public class CagentServiceImpl implements CagentService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentServiceImpl.class);
    
    @Autowired
    private CagentMapper cagentMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Cagent record) {
        return cagentMapper.insertSelective(record);
    }

    @Override
    public Cagent selectByPrimaryKey(Integer id) {
        return cagentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cagent record) {
        return cagentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<Cagent> list(Map<String, String> params) throws RRException{
        Pager<Cagent> pager = new Pager<>(params);
        //根据条件查询用户列表
        List<Cagent> users = cagentMapper.findAllByPage(pager);
        //根据条件查询用户总条数
        int totalCounts = cagentMapper.getCagentTotalCounts(pager);
        //总条数
        Pager<Cagent> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(users);
        return result;
    }

    @Override
    public List<Cagent> getCagentSelectList(Integer id) throws RRException{
        return cagentMapper.findAllByCid(id);
    }

    /**
     * 保存平台商信息
     */
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
    @Override
    public int save(Cagent cagent) throws RRException {
        //判断保存状态,id为空则为新增 否则 为修改
        if(cagent.getId() == null){
            //新增
            cagent.setStatus(0);
            cagent.setAddtime(new Date());
            return cagentMapper.insertSelective(cagent);
        }else{
            //通过平台ID查询平台信息
            Cagent c = cagentMapper.selectByPrimaryKey(cagent.getId());
            if(c == null){
                logger.info("修改平台信息失败,通过平台ID:["+cagent.getId()+"]查询不到平台信息");
                throw new RRException("修改平台信息失败,通过平台ID:["+cagent.getId()+"]查询不到平台信息");
            }
            BeanUtils.copyProperties(cagent, c);
            //更新平台信息
            return cagentMapper.updateByPrimaryKeySelective(c);
        }
    }

    /**
     * 
     * @Description 禁用或启用平台
     * @param id
     * @param status
     * @return
     * @throws RRException
     */
    @Override
    public int disableOrEnable(Integer id, Integer status) throws RRException {
        if(status == 0 || status == 1 || status == 2){
            return cagentMapper.disableOrEnable(id, status);
        }else{
            logger.info("修改平台状态异常,平台ID:["+id+"],平台状态值:{}",status);
            throw new RRException("请输入正确平台状态值");
        }
    }
}
