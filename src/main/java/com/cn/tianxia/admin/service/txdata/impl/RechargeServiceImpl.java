package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.RechargeMapper;
import com.cn.tianxia.admin.project.txdata.Recharge;
import com.cn.tianxia.admin.service.txdata.RechargeService;


@Service
public class RechargeServiceImpl implements RechargeService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(RechargeServiceImpl.class);
    
    @Autowired
    private RechargeMapper rechargeMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer rId) {
        return rechargeMapper.deleteByPrimaryKey(rId);
    }

    @Override
    public int insertSelective(Recharge record) {
        return rechargeMapper.insertSelective(record);
    }

    @Override
    public Recharge selectByPrimaryKey(Integer rId) {
        return rechargeMapper.selectByPrimaryKey(rId);
    }

    @Override
    public int updateByPrimaryKeySelective(Recharge record) {
        return rechargeMapper.updateByPrimaryKeySelective(record);
    }

}
