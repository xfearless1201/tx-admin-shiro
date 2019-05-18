package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentWashcodeConfigMapper;
import com.cn.tianxia.admin.project.txdata.CagentWashcodeConfig;
import com.cn.tianxia.admin.service.txdata.CagentWashcodeConfigService;

@Service
public class CagentWashcodeConfigServiceImpl implements CagentWashcodeConfigService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentWashcodeConfigServiceImpl.class);
    
    @Autowired
    private CagentWashcodeConfigMapper cagentWashcodeConfigMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentWashcodeConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentWashcodeConfig record) {
        return cagentWashcodeConfigMapper.insertSelective(record);
    }

    @Override
    public CagentWashcodeConfig selectByPrimaryKey(Integer id) {
        return cagentWashcodeConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentWashcodeConfig record) {
        return cagentWashcodeConfigMapper.updateByPrimaryKeySelective(record);
    }

}
