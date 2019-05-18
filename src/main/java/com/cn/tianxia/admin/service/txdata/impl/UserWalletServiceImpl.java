package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserWalletMapper;
import com.cn.tianxia.admin.project.txdata.UserWallet;
import com.cn.tianxia.admin.service.txdata.UserWalletService;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(UserWalletServiceImpl.class);

    @Autowired
    private UserWalletMapper userWalletMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userWalletMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserWallet record) {
        return userWalletMapper.insertSelective(record);
    }

    @Override
    public UserWallet selectByPrimaryKey(Integer id) {
        return userWalletMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserWallet record) {
        return userWalletMapper.updateByPrimaryKeySelective(record);
    }

}
