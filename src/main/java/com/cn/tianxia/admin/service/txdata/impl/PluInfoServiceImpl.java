package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PluInfoMapper;
import com.cn.tianxia.admin.project.txdata.PluInfo;
import com.cn.tianxia.admin.service.txdata.PluInfoService;

@Service
public class PluInfoServiceImpl implements PluInfoService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PluInfoServiceImpl.class);
    
    @Autowired
    private PluInfoMapper pluInfoMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pluInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PluInfo record) {
        return pluInfoMapper.insertSelective(record);
    }

    @Override
    public PluInfo selectByPrimaryKey(Integer id) {
        return pluInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PluInfo record) {
        return pluInfoMapper.updateByPrimaryKeySelective(record);
    }

    
}
