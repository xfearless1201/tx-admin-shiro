package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserTreasureMapper;
import com.cn.tianxia.admin.project.txdata.UserTreasure;
import com.cn.tianxia.admin.service.txdata.UserTreasureService;

@Service
public class UserTreasureServiceImpl implements UserTreasureService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(UserTreasureServiceImpl.class);

    @Autowired
    private UserTreasureMapper userTreasureMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userTreasureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserTreasure record) {
        return userTreasureMapper.insertSelective(record);
    }

    @Override
    public UserTreasure selectByPrimaryKey(Integer id) {
        return userTreasureMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserTreasure record) {
        return userTreasureMapper.updateByPrimaryKeySelective(record);
    }

}
