package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.JuniorProxyFeeConfigMapper;
import com.cn.tianxia.admin.project.txdata.JuniorProxyFeeConfig;
import com.cn.tianxia.admin.service.txdata.JuniorProxyFeeConfigService;

@Service
public class JuniorProxyFeeConfigServiceImpl implements JuniorProxyFeeConfigService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(JuniorProxyFeeConfigServiceImpl.class);
    
    @Autowired
    private JuniorProxyFeeConfigMapper juniorProxyFeeConfigMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return juniorProxyFeeConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(JuniorProxyFeeConfig record) {
        return juniorProxyFeeConfigMapper.insertSelective(record);
    }

    @Override
    public JuniorProxyFeeConfig selectByPrimaryKey(Integer id) {
        return juniorProxyFeeConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JuniorProxyFeeConfig record) {
        return juniorProxyFeeConfigMapper.updateByPrimaryKeySelective(record);
    }

}
