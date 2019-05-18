package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ProxyFeeConfigMapper;
import com.cn.tianxia.admin.project.txdata.ProxyFeeConfig;
import com.cn.tianxia.admin.service.txdata.ProxyFeeConfigService;

@Service
public class ProxyFeeConfigServiceImpl implements ProxyFeeConfigService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ProxyFeeConfigServiceImpl.class);
    
    @Autowired
    private ProxyFeeConfigMapper proxyFeeConfigMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return proxyFeeConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ProxyFeeConfig record) {
        return proxyFeeConfigMapper.insertSelective(record);
    }

    @Override
    public ProxyFeeConfig selectByPrimaryKey(Integer id) {
        return proxyFeeConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProxyFeeConfig record) {
        return proxyFeeConfigMapper.updateByPrimaryKeySelective(record);
    }

}
