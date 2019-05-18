package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PsAuthMapper;
import com.cn.tianxia.admin.project.txdata.PsAuth;
import com.cn.tianxia.admin.service.txdata.PsAuthService;

@Service
public class PsAuthServiceImpl implements PsAuthService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PsAuthServiceImpl.class);
    
    @Autowired
    private PsAuthMapper psAuthMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return psAuthMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PsAuth record) {
        return psAuthMapper.insertSelective(record);
    }

    @Override
    public PsAuth selectByPrimaryKey(Integer id) {
        return psAuthMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PsAuth record) {
        return psAuthMapper.updateByPrimaryKeySelective(record);
    }

}
