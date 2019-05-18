package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.WebcomImgMapper;
import com.cn.tianxia.admin.project.txdata.WebcomImg;
import com.cn.tianxia.admin.service.txdata.WebcomImgService;

@Service
public class WebcomImgServiceImpl implements WebcomImgService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(WebcomImgServiceImpl.class);
    
    @Autowired
    private WebcomImgMapper webcomImgMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return webcomImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(WebcomImg record) {
        return webcomImgMapper.insertSelective(record);
    }

    @Override
    public WebcomImg selectByPrimaryKey(Integer id) {
        return webcomImgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WebcomImg record) {
        return webcomImgMapper.updateByPrimaryKeySelective(record);
    }

}
