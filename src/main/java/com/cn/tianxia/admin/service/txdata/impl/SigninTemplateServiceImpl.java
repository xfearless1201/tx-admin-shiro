package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.SigninTemplateMapper;
import com.cn.tianxia.admin.project.txdata.SigninTemplate;
import com.cn.tianxia.admin.service.txdata.SigninTemplateService;

@Service
public class SigninTemplateServiceImpl implements SigninTemplateService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(SigninTemplateServiceImpl.class);
    
    @Autowired
    private SigninTemplateMapper signinTemplateMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return signinTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SigninTemplate record) {
        return signinTemplateMapper.insertSelective(record);
    }

    @Override
    public SigninTemplate selectByPrimaryKey(Integer id) {
        return signinTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SigninTemplate record) {
        return signinTemplateMapper.updateByPrimaryKeySelective(record);
    }

}
