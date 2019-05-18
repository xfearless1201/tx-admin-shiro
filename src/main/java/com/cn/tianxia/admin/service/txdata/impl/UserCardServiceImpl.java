package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserCardMapper;
import com.cn.tianxia.admin.project.txdata.UserCard;
import com.cn.tianxia.admin.service.txdata.UserCardService;

@Service
public class UserCardServiceImpl implements UserCardService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserCardServiceImpl.class);
    
    @Autowired
    private UserCardMapper userCardMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userCardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserCard record) {
        return userCardMapper.insertSelective(record);
    }

    @Override
    public UserCard selectByPrimaryKey(Integer id) {
        return userCardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserCard record) {
        return userCardMapper.updateByPrimaryKeySelective(record);
    }

}
