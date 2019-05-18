package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.JuniorProxyUserTsMapper;
import com.cn.tianxia.admin.project.txdata.JuniorProxyUserTs;
import com.cn.tianxia.admin.service.txdata.JuniorProxyUserTsService;

@Service
public class JuniorProxyUserTsServiceImpl implements JuniorProxyUserTsService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(JuniorProxyUserTsServiceImpl.class);
    
    @Autowired
    private JuniorProxyUserTsMapper juniorProxyUserTsMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return juniorProxyUserTsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(JuniorProxyUserTs record) {
        return juniorProxyUserTsMapper.insertSelective(record);
    }

    @Override
    public JuniorProxyUserTs selectByPrimaryKey(Integer id) {
        return juniorProxyUserTsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JuniorProxyUserTs record) {
        return juniorProxyUserTsMapper.updateByPrimaryKeySelective(record);
    }

}
