package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.RefererUrlMapper;
import com.cn.tianxia.admin.project.txdata.RefererUrl;
import com.cn.tianxia.admin.service.txdata.RefererUrlService;

@Service
public class RefererUrlServiceImpl implements RefererUrlService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(RefererUrlServiceImpl.class);
    
    @Autowired
    private RefererUrlMapper refererUrlMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return refererUrlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RefererUrl record) {
        return refererUrlMapper.insertSelective(record);
    }

    @Override
    public RefererUrl selectByPrimaryKey(Integer id) {
        return refererUrlMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RefererUrl record) {
        return refererUrlMapper.updateByPrimaryKeySelective(record);
    }

}
