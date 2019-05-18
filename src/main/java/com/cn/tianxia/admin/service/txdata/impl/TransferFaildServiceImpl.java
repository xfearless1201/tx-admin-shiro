package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.TransferFaildMapper;
import com.cn.tianxia.admin.project.txdata.TransferFaild;
import com.cn.tianxia.admin.service.txdata.TransferFaildService;

@Service
public class TransferFaildServiceImpl implements TransferFaildService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(TransferFaildServiceImpl.class);
    
    @Autowired
    private TransferFaildMapper transferFaildMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return transferFaildMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(TransferFaild record) {
        return transferFaildMapper.insertSelective(record);
    }

    @Override
    public TransferFaild selectByPrimaryKey(Integer id) {
        return transferFaildMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TransferFaild record) {
        return transferFaildMapper.updateByPrimaryKeySelective(record);
    }
}
