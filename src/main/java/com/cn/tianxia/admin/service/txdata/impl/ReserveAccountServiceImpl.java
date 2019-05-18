package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ReserveAccountMapper;
import com.cn.tianxia.admin.project.txdata.ReserveAccount;
import com.cn.tianxia.admin.service.txdata.ReserveAccountService;

@Service
public class ReserveAccountServiceImpl implements ReserveAccountService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ReserveAccountServiceImpl.class);
    
    @Autowired
    private ReserveAccountMapper reserveAccountMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return reserveAccountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ReserveAccount record) {
        return reserveAccountMapper.insertSelective(record);
    }

    @Override
    public ReserveAccount selectByPrimaryKey(Integer id) {
        return reserveAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ReserveAccount record) {
        return reserveAccountMapper.updateByPrimaryKeySelective(record);
    }

}
