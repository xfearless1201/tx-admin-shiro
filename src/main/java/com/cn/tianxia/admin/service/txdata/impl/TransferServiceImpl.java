package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.TransferMapper;
import com.cn.tianxia.admin.project.txdata.Transfer;
import com.cn.tianxia.admin.service.txdata.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class);
    
    @Autowired
    private TransferMapper transferMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return transferMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Transfer record) {
        return transferMapper.insertSelective(record);
    }

    @Override
    public Transfer selectByPrimaryKey(Integer id) {
        return transferMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Transfer record) {
        return transferMapper.updateByPrimaryKeySelective(record);
    }

    
}
