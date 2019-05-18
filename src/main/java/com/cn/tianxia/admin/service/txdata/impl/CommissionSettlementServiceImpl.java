package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CommissionSettlementMapper;
import com.cn.tianxia.admin.project.txdata.CommissionSettlement;
import com.cn.tianxia.admin.service.txdata.CommissionSettlementService;

@Service
public class CommissionSettlementServiceImpl implements CommissionSettlementService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CommissionSettlementServiceImpl.class);
    
    @Autowired
    private CommissionSettlementMapper commissionSettlementMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commissionSettlementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CommissionSettlement record) {
        return commissionSettlementMapper.insertSelective(record);
    }

    @Override
    public CommissionSettlement selectByPrimaryKey(Integer id) {
        return commissionSettlementMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CommissionSettlement record) {
        return commissionSettlementMapper.updateByPrimaryKeySelective(record);
    }

}
