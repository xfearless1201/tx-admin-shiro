package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.IpwhitelistMapper;
import com.cn.tianxia.admin.project.txdata.Ipwhitelist;
import com.cn.tianxia.admin.service.txdata.IpwhitelistService;

@Service
public class IpwhitelistServiceImpl implements IpwhitelistService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(IpwhitelistServiceImpl.class);
    
    @Autowired
    private IpwhitelistMapper ipwhitelistMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return ipwhitelistMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Ipwhitelist record) {
        return ipwhitelistMapper.insertSelective(record);
    }

    @Override
    public Ipwhitelist selectByPrimaryKey(Integer id) {
        return ipwhitelistMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Ipwhitelist record) {
        return ipwhitelistMapper.updateByPrimaryKeySelective(record);
    }
}
