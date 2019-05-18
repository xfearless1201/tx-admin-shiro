package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ProxySettlementMapper;
import com.cn.tianxia.admin.project.txdata.ProxySettlement;
import com.cn.tianxia.admin.service.txdata.ProxySettlementService;

@Service
public class ProxySettlementServiceImpl implements ProxySettlementService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ProxySettlementServiceImpl.class);
    
    @Autowired
    private ProxySettlementMapper proxySettlementMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return proxySettlementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ProxySettlement record) {
        return proxySettlementMapper.insertSelective(record);
    }

    @Override
    public ProxySettlement selectByPrimaryKey(Integer id) {
        return proxySettlementMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProxySettlement record) {
        return proxySettlementMapper.updateByPrimaryKeySelective(record);
    }

}
