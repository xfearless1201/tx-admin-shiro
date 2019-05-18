package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserRoleMapper;
import com.cn.tianxia.admin.project.txdata.UserRole;
import com.cn.tianxia.admin.service.txdata.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
    
    @Autowired
    private UserRoleMapper userRoleMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    @Override
    public UserRole selectByPrimaryKey(Long id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

}
