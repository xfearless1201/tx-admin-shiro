package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ProxySettlementUserDetailsMapper;
import com.cn.tianxia.admin.project.txdata.ProxySettlementUserDetails;
import com.cn.tianxia.admin.service.txdata.ProxySettlementUserDetailsService;

@Service
public class ProxySettlementUserDetailsServiceImpl implements ProxySettlementUserDetailsService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ProxySettlementUserDetailsServiceImpl.class);
    
    @Autowired
    private ProxySettlementUserDetailsMapper proxySettlementUserDetailsMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return proxySettlementUserDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ProxySettlementUserDetails record) {
        return proxySettlementUserDetailsMapper.insertSelective(record);
    }

    @Override
    public ProxySettlementUserDetails selectByPrimaryKey(Integer id) {
        return proxySettlementUserDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProxySettlementUserDetails record) {
        return proxySettlementUserDetailsMapper.updateByPrimaryKeySelective(record);
    }

}
