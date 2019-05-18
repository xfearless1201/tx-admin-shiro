package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.FundmanageMapper;
import com.cn.tianxia.admin.project.txdata.Fundmanage;
import com.cn.tianxia.admin.service.txdata.FundmanageService;

@Service
public class FundmanageServiceImpl implements FundmanageService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(FundmanageServiceImpl.class);
    
    @Autowired
    private FundmanageMapper fundmanageMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return fundmanageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Fundmanage record) {
        return fundmanageMapper.insertSelective(record);
    }

    @Override
    public Fundmanage selectByPrimaryKey(Integer id) {
        return fundmanageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Fundmanage record) {
        return fundmanageMapper.updateByPrimaryKeySelective(record);
    }

    
}
