package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ContactConfigMapper;
import com.cn.tianxia.admin.project.txdata.ContactConfig;
import com.cn.tianxia.admin.service.txdata.ContactConfigService;

@Service
public class ContactConfigServiceImpl implements ContactConfigService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ContactConfigServiceImpl.class);
    
    @Autowired
    private ContactConfigMapper contactConfigMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return contactConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ContactConfig record) {
        return contactConfigMapper.insertSelective(record);
    }

    @Override
    public ContactConfig selectByPrimaryKey(Integer id) {
        return contactConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ContactConfig record) {
        return contactConfigMapper.updateByPrimaryKeySelective(record);
    }

}
