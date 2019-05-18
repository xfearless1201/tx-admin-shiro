package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserTypeHandicapMapper;
import com.cn.tianxia.admin.project.txdata.UserTypeHandicap;
import com.cn.tianxia.admin.service.txdata.UserTypeHandicapService;

@Service
public class UserTypeHandicapServiceImpl implements UserTypeHandicapService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(UserTypeHandicapServiceImpl.class);

    @Autowired
    private UserTypeHandicapMapper userTypeHandicapMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userTypeHandicapMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserTypeHandicap record) {
        return userTypeHandicapMapper.insertSelective(record);
    }

    @Override
    public UserTypeHandicap selectByPrimaryKey(Integer id) {
        return userTypeHandicapMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserTypeHandicap record) {
        return userTypeHandicapMapper.updateByPrimaryKeySelective(record);
    }
}
