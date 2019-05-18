package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.RoleResourceMapper;
import com.cn.tianxia.admin.project.txdata.RoleResource;
import com.cn.tianxia.admin.service.txdata.RoleResourceService;

@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(RoleResourceServiceImpl.class);
    
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleResourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RoleResource record) {
        return roleResourceMapper.insertSelective(record);
    }

    @Override
    public RoleResource selectByPrimaryKey(Long id) {
        return roleResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleResource record) {
        return roleResourceMapper.updateByPrimaryKeySelective(record);
    }

}
