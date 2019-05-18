package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.IpblacklistMapper;
import com.cn.tianxia.admin.project.txdata.Ipblacklist;
import com.cn.tianxia.admin.service.txdata.IpblacklistService;

@Service
public class IpblacklistServiceImpl implements IpblacklistService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(IpblacklistServiceImpl.class);
    
    @Autowired
    private IpblacklistMapper ipblacklistMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return ipblacklistMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Ipblacklist record) {
        return ipblacklistMapper.insertSelective(record);
    }

    @Override
    public Ipblacklist selectByPrimaryKey(Integer id) {
        return ipblacklistMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Ipblacklist record) {
        return ipblacklistMapper.updateByPrimaryKeySelective(record);
    }

}
