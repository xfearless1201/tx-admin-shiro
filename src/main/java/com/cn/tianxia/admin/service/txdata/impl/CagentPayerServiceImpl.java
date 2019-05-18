package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentPayerMapper;
import com.cn.tianxia.admin.project.txdata.CagentPayer;
import com.cn.tianxia.admin.service.txdata.CagentPayerService;

@Service
public class CagentPayerServiceImpl implements CagentPayerService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentPayerServiceImpl.class);
    
    @Autowired
    private CagentPayerMapper cagentPayerMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentPayerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentPayer record) {
        return cagentPayerMapper.insertSelective(record);
    }

    @Override
    public CagentPayer selectByPrimaryKey(Integer id) {
        return cagentPayerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentPayer record) {
        return cagentPayerMapper.updateByPrimaryKeySelective(record);
    }

}
