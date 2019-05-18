package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PluCateMapper;
import com.cn.tianxia.admin.project.txdata.PluCate;
import com.cn.tianxia.admin.service.txdata.PluCateService;

@Service
public class PluCateServiceImpl implements PluCateService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PluCateServiceImpl.class);
    
    @Autowired
    private PluCateMapper pluCateMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pluCateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PluCate record) {
        return pluCateMapper.insertSelective(record);
    }

    @Override
    public PluCate selectByPrimaryKey(Integer id) {
        return pluCateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PluCate record) {
        return pluCateMapper.updateByPrimaryKeySelective(record);
    }

}
