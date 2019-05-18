package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentStoredvalueMapper;
import com.cn.tianxia.admin.project.txdata.CagentStoredvalue;
import com.cn.tianxia.admin.service.txdata.CagentStoredvalueService;

@Service
public class CagentStoredvalueServiceImpl implements CagentStoredvalueService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentStoredvalueServiceImpl.class);

    @Autowired
    private CagentStoredvalueMapper cagentStoredvalueMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentStoredvalueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentStoredvalue record) {
        return cagentStoredvalueMapper.insertSelective(record);
    }

    @Override
    public CagentStoredvalue selectByPrimaryKey(Integer id) {
        return cagentStoredvalueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentStoredvalue record) {
        return cagentStoredvalueMapper.updateByPrimaryKeySelective(record);
    }
}
