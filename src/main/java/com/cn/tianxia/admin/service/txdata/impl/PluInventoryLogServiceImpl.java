package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PluInventoryLogMapper;
import com.cn.tianxia.admin.project.txdata.PluInventoryLog;
import com.cn.tianxia.admin.service.txdata.PluInventoryLogService;

@Service
public class PluInventoryLogServiceImpl implements PluInventoryLogService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PluInventoryLogServiceImpl.class);
    
    @Autowired
    private PluInventoryLogMapper pluInventoryLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pluInventoryLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PluInventoryLog record) {
        return pluInventoryLogMapper.insertSelective(record);
    }

    @Override
    public PluInventoryLog selectByPrimaryKey(Integer id) {
        return pluInventoryLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PluInventoryLog record) {
        return pluInventoryLogMapper.updateByPrimaryKeySelective(record);
    }

}
