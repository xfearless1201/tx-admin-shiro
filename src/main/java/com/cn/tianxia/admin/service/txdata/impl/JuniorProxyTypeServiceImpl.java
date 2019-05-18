package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.JuniorProxyTypeMapper;
import com.cn.tianxia.admin.project.txdata.JuniorProxyType;
import com.cn.tianxia.admin.service.txdata.JuniorProxyTypeService;

@Service
public class JuniorProxyTypeServiceImpl implements JuniorProxyTypeService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(JuniorProxyTypeServiceImpl.class);
    
    @Autowired
    private JuniorProxyTypeMapper juniorProxyTypeMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return juniorProxyTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(JuniorProxyType record) {
        return juniorProxyTypeMapper.insertSelective(record);
    }

    @Override
    public JuniorProxyType selectByPrimaryKey(Integer id) {
        return juniorProxyTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JuniorProxyType record) {
        return juniorProxyTypeMapper.updateByPrimaryKeySelective(record);
    }

}
