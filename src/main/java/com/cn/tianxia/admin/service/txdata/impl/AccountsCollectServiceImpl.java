package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.AccountsCollectMapper;
import com.cn.tianxia.admin.project.txdata.AccountsCollect;
import com.cn.tianxia.admin.service.txdata.AccountsCollectService;


/**
 * 
 * @ClassName AccountsCollectServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:01:12
 * @version 1.0.0
 */
@Service
public class AccountsCollectServiceImpl implements AccountsCollectService {
    
    //日志
    private static final Logger logger = LoggerFactory.getLogger(AccountsCollectServiceImpl.class);
    
    @Autowired
    private AccountsCollectMapper accountsCollectMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return accountsCollectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(AccountsCollect record) {
        return accountsCollectMapper.insertSelective(record);
    }

    @Override
    public AccountsCollect selectByPrimaryKey(Integer id) {
        return accountsCollectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AccountsCollect record) {
        return accountsCollectMapper.updateByPrimaryKeySelective(record);
    }

}
