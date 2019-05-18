package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserQuantityMapper;
import com.cn.tianxia.admin.project.txdata.UserQuantity;
import com.cn.tianxia.admin.service.txdata.UserQuantityService;

@Service
public class UserQuantityServiceImpl implements UserQuantityService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserQuantityServiceImpl.class);
    
    @Autowired
    private UserQuantityMapper userQuantityMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userQuantityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserQuantity record) {
        return userQuantityMapper.insertSelective(record);
    }

    @Override
    public UserQuantity selectByPrimaryKey(Integer id) {
        return userQuantityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserQuantity record) {
        return userQuantityMapper.updateByPrimaryKeySelective(record);
    }

}
