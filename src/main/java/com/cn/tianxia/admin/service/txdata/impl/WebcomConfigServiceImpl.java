package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.WebcomConfigMapper;
import com.cn.tianxia.admin.project.txdata.WebcomConfig;
import com.cn.tianxia.admin.service.txdata.WebcomConfigService;

@Service
public class WebcomConfigServiceImpl implements WebcomConfigService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(WebcomConfigServiceImpl.class);
    
    @Autowired
    private WebcomConfigMapper webcomConfigMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return webcomConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(WebcomConfig record) {
        return webcomConfigMapper.insertSelective(record);
    }

    @Override
    public WebcomConfig selectByPrimaryKey(Integer id) {
        return webcomConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WebcomConfig record) {
        return webcomConfigMapper.updateByPrimaryKeySelective(record);
    }

}
