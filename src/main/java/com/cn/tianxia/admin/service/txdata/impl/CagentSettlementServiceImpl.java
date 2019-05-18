package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentSettlementMapper;
import com.cn.tianxia.admin.project.txdata.CagentSettlement;
import com.cn.tianxia.admin.service.txdata.CagentSettlementService;

@Service
public class CagentSettlementServiceImpl implements CagentSettlementService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentSettlementServiceImpl.class);
    
    @Autowired
    private CagentSettlementMapper cagentSettlementMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentSettlementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentSettlement record) {
        return cagentSettlementMapper.insertSelective(record);
    }

    @Override
    public CagentSettlement selectByPrimaryKey(Integer id) {
        return cagentSettlementMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentSettlement record) {
        return cagentSettlementMapper.updateByPrimaryKeySelective(record);
    }

}
