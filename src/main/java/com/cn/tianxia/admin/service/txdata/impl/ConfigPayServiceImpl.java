package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ConfigPayMapper;
import com.cn.tianxia.admin.project.txdata.ConfigPay;
import com.cn.tianxia.admin.service.txdata.ConfigPayService;

@Service
public class ConfigPayServiceImpl implements ConfigPayService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ConfigPayServiceImpl.class);
    
    @Autowired
    private ConfigPayMapper configPayMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return configPayMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ConfigPay record) {
        return configPayMapper.insertSelective(record);
    }

    @Override
    public ConfigPay selectByPrimaryKey(Integer id) {
        return configPayMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ConfigPay record) {
        return configPayMapper.updateByPrimaryKeySelective(record);
    }

}
