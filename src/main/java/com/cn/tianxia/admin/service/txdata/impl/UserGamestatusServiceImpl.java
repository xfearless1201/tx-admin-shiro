package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserGamestatusMapper;
import com.cn.tianxia.admin.project.txdata.UserGamestatus;
import com.cn.tianxia.admin.service.txdata.UserGamestatusService;

@Service
public class UserGamestatusServiceImpl implements UserGamestatusService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserGamestatusServiceImpl.class);
    
    @Autowired
    private UserGamestatusMapper userGamestatusMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userGamestatusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserGamestatus record) {
        return userGamestatusMapper.insertSelective(record);
    }

    @Override
    public UserGamestatus selectByPrimaryKey(Integer id) {
        return userGamestatusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserGamestatus record) {
        return userGamestatusMapper.updateByPrimaryKeySelective(record);
    }

}
