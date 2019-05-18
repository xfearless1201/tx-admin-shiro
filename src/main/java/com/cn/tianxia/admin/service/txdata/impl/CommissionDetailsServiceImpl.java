package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CommissionDetailsMapper;
import com.cn.tianxia.admin.project.txdata.CommissionDetails;
import com.cn.tianxia.admin.service.txdata.CommissionDetailsService;

@Service
public class CommissionDetailsServiceImpl implements CommissionDetailsService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CommissionDetailsServiceImpl.class);
    
    @Autowired
    private CommissionDetailsMapper commissionDetailsMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commissionDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CommissionDetails record) {
        return commissionDetailsMapper.insertSelective(record);
    }

    @Override
    public CommissionDetails selectByPrimaryKey(Integer id) {
        return commissionDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CommissionDetails record) {
        return commissionDetailsMapper.updateByPrimaryKeySelective(record);
    }

    
}
