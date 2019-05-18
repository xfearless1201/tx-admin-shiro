package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.AccountDaySumMapper;
import com.cn.tianxia.admin.project.txdata.AccountDaySum;
import com.cn.tianxia.admin.service.txdata.AccountDaySumService;


/**
 * 
 * @ClassName AccountDaySumServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:01:07
 * @version 1.0.0
 */
@Service
public class AccountDaySumServiceImpl implements AccountDaySumService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(AccountDaySumServiceImpl.class);
    
    @Autowired
    private AccountDaySumMapper accountDaySumMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return accountDaySumMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(AccountDaySum record) {
        return accountDaySumMapper.insertSelective(record);
    }

    @Override
    public AccountDaySum selectByPrimaryKey(Long id) {
        return accountDaySumMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AccountDaySum record) {
        return accountDaySumMapper.updateByPrimaryKeySelective(record);
    }
    
}
