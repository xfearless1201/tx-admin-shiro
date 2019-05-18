package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PayChannelMapper;
import com.cn.tianxia.admin.project.txdata.PayChannel;
import com.cn.tianxia.admin.service.txdata.PayChannelService;

@Service
public class PayChannelServiceImpl implements PayChannelService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PayChannelServiceImpl.class);
    
    @Autowired
    private PayChannelMapper payChannelMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return payChannelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PayChannel record) {
        return payChannelMapper.insertSelective(record);
    }

    @Override
    public PayChannel selectByPrimaryKey(Integer id) {
        return payChannelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PayChannel record) {
        return payChannelMapper.updateByPrimaryKeySelective(record);
    }

}
