package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.OperatorLogMapper;
import com.cn.tianxia.admin.project.txdata.OperatorLog;
import com.cn.tianxia.admin.service.txdata.OperatorLogService;

@Service
public class OperatorLogServiceImpl implements OperatorLogService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(OperatorLogServiceImpl.class);
    
    @Autowired
    private OperatorLogMapper operatorLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return operatorLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(OperatorLog record) {
        return operatorLogMapper.insertSelective(record);
    }

    @Override
    public OperatorLog selectByPrimaryKey(Integer id) {
        return operatorLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OperatorLog record) {
        return operatorLogMapper.updateByPrimaryKeySelective(record);
    }

}
