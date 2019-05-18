package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.GuagualeActivityMapper;
import com.cn.tianxia.admin.project.txdata.GuagualeActivity;
import com.cn.tianxia.admin.service.txdata.GuagualeActivityService;

@Service
public class GuagualeActivityServiceImpl implements GuagualeActivityService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(GuagualeActivityServiceImpl.class);
    
    @Autowired
    private GuagualeActivityMapper guagualeActivityMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return guagualeActivityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(GuagualeActivity record) {
        return guagualeActivityMapper.insertSelective(record);
    }

    @Override
    public GuagualeActivity selectByPrimaryKey(Long id) {
        return guagualeActivityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GuagualeActivity record) {
        return guagualeActivityMapper.updateByPrimaryKeySelective(record);
    }

}
