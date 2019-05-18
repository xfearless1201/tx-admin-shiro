package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.SysLogMapper;
import com.cn.tianxia.admin.project.txdata.SysLogInfo;
import com.cn.tianxia.admin.service.txdata.SysLogService;

@Service
public class SysLogServiceImpl implements SysLogService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);
    
    @Autowired
    private SysLogMapper sysLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysLogInfo record) {
        return sysLogMapper.insertSelective(record);
    }

    @Override
    public SysLogInfo selectByPrimaryKey(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysLogInfo record) {
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

}
