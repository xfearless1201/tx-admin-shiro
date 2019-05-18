package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.JuniorProxyUserTyMapper;
import com.cn.tianxia.admin.project.txdata.JuniorProxyUserTy;
import com.cn.tianxia.admin.service.txdata.JuniorProxyUserTyService;

@Service
public class JuniorProxyUserTyServiceImpl implements JuniorProxyUserTyService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(JuniorProxyUserTyServiceImpl.class);
    
    @Autowired
    private JuniorProxyUserTyMapper juniorProxyUserTyMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return juniorProxyUserTyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(JuniorProxyUserTy record) {
        return juniorProxyUserTyMapper.insertSelective(record);
    }

    @Override
    public JuniorProxyUserTy selectByPrimaryKey(Integer id) {
        return juniorProxyUserTyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JuniorProxyUserTy record) {
        return juniorProxyUserTyMapper.updateByPrimaryKeySelective(record);
    }

}
