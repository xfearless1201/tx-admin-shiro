package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ProxyUserTsMapper;
import com.cn.tianxia.admin.project.txdata.ProxyUserTs;
import com.cn.tianxia.admin.service.txdata.ProxyUserTsService;

@Service
public class ProxyUserTsServiceImpl implements ProxyUserTsService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ProxyTypeServiceImpl.class);
    
    @Autowired
    private ProxyUserTsMapper proxyUserTsMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return proxyUserTsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ProxyUserTs record) {
        return proxyUserTsMapper.insertSelective(record);
    }

    @Override
    public ProxyUserTs selectByPrimaryKey(Integer id) {
        return proxyUserTsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProxyUserTs record) {
        return proxyUserTsMapper.updateByPrimaryKeySelective(record);
    }

    
}
