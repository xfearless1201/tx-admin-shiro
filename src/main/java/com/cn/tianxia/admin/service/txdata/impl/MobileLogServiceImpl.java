package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.MobileLogMapper;
import com.cn.tianxia.admin.project.txdata.MobileLog;
import com.cn.tianxia.admin.service.txdata.MobileLogService;

@Service
public class MobileLogServiceImpl implements MobileLogService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(MobileLogServiceImpl.class);
    
    @Autowired
    private MobileLogMapper mobileLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mobileLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(MobileLog record) {
        return mobileLogMapper.insertSelective(record);
    }

    @Override
    public MobileLog selectByPrimaryKey(Integer id) {
        return mobileLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MobileLog record) {
        return mobileLogMapper.updateByPrimaryKeySelective(record);
    }

}
