package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentStoredvalueLogMapper;
import com.cn.tianxia.admin.project.txdata.CagentStoredvalueLog;
import com.cn.tianxia.admin.service.txdata.CagentStoredvalueLogService;

@Service
public class CagentStoredvalueLogServiceImpl implements CagentStoredvalueLogService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentStoredvalueServiceImpl.class);

    @Autowired
    private CagentStoredvalueLogMapper cagentStoredvalueLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentStoredvalueLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentStoredvalueLog record) {
        return cagentStoredvalueLogMapper.insertSelective(record);
    }

    @Override
    public CagentStoredvalueLog selectByPrimaryKey(Integer id) {
        return cagentStoredvalueLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentStoredvalueLog record) {
        return cagentStoredvalueLogMapper.updateByPrimaryKeySelective(record);
    }
}
