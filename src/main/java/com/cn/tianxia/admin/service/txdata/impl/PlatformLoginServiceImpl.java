package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PlatformLoginMapper;
import com.cn.tianxia.admin.project.txdata.PlatformLogin;
import com.cn.tianxia.admin.service.txdata.PlatformLoginService;

@Service
public class PlatformLoginServiceImpl implements PlatformLoginService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PlatformLoginServiceImpl.class);
    
    @Autowired
    private PlatformLoginMapper platformLoginMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return platformLoginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PlatformLogin record) {
        return platformLoginMapper.insertSelective(record);
    }

    @Override
    public PlatformLogin selectByPrimaryKey(Integer id) {
        return platformLoginMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PlatformLogin record) {
        return platformLoginMapper.updateByPrimaryKeySelective(record);
    }

}
