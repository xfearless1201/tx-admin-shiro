package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.OnlinepayCallbackLogMapper;
import com.cn.tianxia.admin.project.txdata.OnlinepayCallbackLog;
import com.cn.tianxia.admin.service.txdata.OnlinepayCallbackLogService;

@Service
public class OnlinepayCallbackLogServiceImpl implements OnlinepayCallbackLogService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(OnlinepayCallbackLogServiceImpl.class);
    
    @Autowired
    private OnlinepayCallbackLogMapper onlinepayCallbackLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return onlinepayCallbackLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(OnlinepayCallbackLog record) {
        return onlinepayCallbackLogMapper.insertSelective(record);
    }

    @Override
    public OnlinepayCallbackLog selectByPrimaryKey(Integer id) {
        return onlinepayCallbackLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OnlinepayCallbackLog record) {
        return onlinepayCallbackLogMapper.updateByPrimaryKeySelective(record);
    }

}
