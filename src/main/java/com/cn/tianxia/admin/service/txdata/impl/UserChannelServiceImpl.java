package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserChannelMapper;
import com.cn.tianxia.admin.project.txdata.UserChannel;
import com.cn.tianxia.admin.service.txdata.UserChannelService;

@Service
public class UserChannelServiceImpl implements UserChannelService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserChannelServiceImpl.class);
    
    @Autowired
    private UserChannelMapper userChannelMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return userChannelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserChannel record) {
        return userChannelMapper.insertSelective(record);
    }

    @Override
    public UserChannel selectByPrimaryKey(Long id) {
        return userChannelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserChannel record) {
        return userChannelMapper.updateByPrimaryKeySelective(record);
    }

}
