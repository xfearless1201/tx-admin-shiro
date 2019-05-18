package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.BankMapper;
import com.cn.tianxia.admin.project.txdata.Bank;
import com.cn.tianxia.admin.service.txdata.BankService;

/**
 * 
 * @ClassName BankServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:11:22
 * @version 1.0.0
 */
@Service
public class BankServiceImpl implements BankService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);
    
    @Autowired
    private BankMapper bankMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bankMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Bank record) {
        return bankMapper.insertSelective(record);
    }

    @Override
    public Bank selectByPrimaryKey(Integer id) {
        return bankMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Bank record) {
        return bankMapper.updateByPrimaryKeySelective(record);
    }

    
}
