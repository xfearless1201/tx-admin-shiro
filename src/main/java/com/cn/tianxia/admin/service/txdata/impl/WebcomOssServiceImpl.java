package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.WebcomOssMapper;
import com.cn.tianxia.admin.project.txdata.WebcomOss;
import com.cn.tianxia.admin.service.txdata.WebcomOssService;

@Service
public class WebcomOssServiceImpl implements WebcomOssService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(WebcomOssServiceImpl.class);
    
    @Autowired
    private WebcomOssMapper webcomOssMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return webcomOssMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(WebcomOss record) {
        return webcomOssMapper.insertSelective(record);
    }

    @Override
    public WebcomOss selectByPrimaryKey(Integer id) {
        return webcomOssMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WebcomOss record) {
        return webcomOssMapper.updateByPrimaryKeySelective(record);
    }

}
