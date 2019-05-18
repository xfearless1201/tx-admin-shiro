package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentWalletMapper;
import com.cn.tianxia.admin.project.txdata.CagentWallet;
import com.cn.tianxia.admin.service.txdata.CagentWalletService;

/**
 * 
 * @ClassName CagentWalletServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午4:33:09
 * @version 1.0.0
 */
@Service
public class CagentWalletServiceImpl implements CagentWalletService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentWalletServiceImpl.class);
    
    @Autowired
    private CagentWalletMapper cagentWalletMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentWalletMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentWallet record) {
        return cagentWalletMapper.insertSelective(record);
    }

    @Override
    public CagentWallet selectByPrimaryKey(Integer id) {
        return cagentWalletMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentWallet record) {
        return cagentWalletMapper.updateByPrimaryKeySelective(record);
    }

}
