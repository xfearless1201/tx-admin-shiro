package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.WithdrawMapper;
import com.cn.tianxia.admin.project.txdata.Withdraw;
import com.cn.tianxia.admin.service.txdata.WithdrawService;

@Service
public class WithdrawServiceImpl implements WithdrawService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(WithdrawServiceImpl.class);
    
    @Autowired
    private WithdrawMapper withdrawMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return withdrawMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Withdraw record) {
        return withdrawMapper.insertSelective(record);
    }

    @Override
    public Withdraw selectByPrimaryKey(Integer id) {
        return withdrawMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Withdraw record) {
        return withdrawMapper.updateByPrimaryKeySelective(record);
    }

}
