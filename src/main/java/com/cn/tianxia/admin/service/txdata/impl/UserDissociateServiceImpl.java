package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserDissociateMapper;
import com.cn.tianxia.admin.project.txdata.UserDissociate;
import com.cn.tianxia.admin.service.txdata.UserDissociateService;

@Service
public class UserDissociateServiceImpl implements UserDissociateService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserDissociateServiceImpl.class);
    
    @Autowired
    private UserDissociateMapper userDissociateMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return userDissociateMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insertSelective(UserDissociate record) {
        return userDissociateMapper.insertSelective(record);
    }

    @Override
    public UserDissociate selectByPrimaryKey(Integer uid) {
        return userDissociateMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(UserDissociate record) {
        return userDissociateMapper.updateByPrimaryKeySelective(record);
    }

}
