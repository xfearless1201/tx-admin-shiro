package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentWalletLogMapper;
import com.cn.tianxia.admin.project.txdata.CagentWalletLog;
import com.cn.tianxia.admin.service.txdata.CagentWalletLogService;

@Service
public class CagentWalletLogServiceImpl implements CagentWalletLogService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentWalletLogServiceImpl.class);
    
    @Autowired
    private CagentWalletLogMapper cagentWalletLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentWalletLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentWalletLog record) {
        return cagentWalletLogMapper.insertSelective(record);
    }

    @Override
    public CagentWalletLog selectByPrimaryKey(Integer id) {
        return cagentWalletLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentWalletLog record) {
        return cagentWalletLogMapper.updateByPrimaryKeySelective(record);
    }

    

}
