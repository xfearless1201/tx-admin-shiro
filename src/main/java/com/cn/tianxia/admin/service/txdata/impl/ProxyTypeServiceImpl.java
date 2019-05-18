package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ProxyTypeMapper;
import com.cn.tianxia.admin.project.txdata.ProxyType;
import com.cn.tianxia.admin.service.txdata.ProxyTypeService;

@Service
public class ProxyTypeServiceImpl implements ProxyTypeService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ProxyTypeServiceImpl.class);
    
    @Autowired
    private ProxyTypeMapper proxyTypeMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return proxyTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ProxyType record) {
        return proxyTypeMapper.insertSelective(record);
    }

    @Override
    public ProxyType selectByPrimaryKey(Integer id) {
        return proxyTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProxyType record) {
        return proxyTypeMapper.updateByPrimaryKeySelective(record);
    }

}
