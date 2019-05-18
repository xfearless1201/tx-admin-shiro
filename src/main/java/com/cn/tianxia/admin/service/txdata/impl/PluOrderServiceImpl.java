package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PluOrderMapper;
import com.cn.tianxia.admin.project.txdata.PluOrder;
import com.cn.tianxia.admin.service.txdata.PluOrderService;

@Service
public class PluOrderServiceImpl implements PluOrderService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PluOrderServiceImpl.class);
    
    @Autowired
    private PluOrderMapper pluOrderMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pluOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PluOrder record) {
        return pluOrderMapper.insertSelective(record);
    }

    @Override
    public PluOrder selectByPrimaryKey(Integer id) {
        return pluOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PluOrder record) {
        return pluOrderMapper.updateByPrimaryKeySelective(record);
    }

}
