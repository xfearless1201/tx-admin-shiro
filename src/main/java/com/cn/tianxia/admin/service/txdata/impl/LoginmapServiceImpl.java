package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.LoginmapMapper;
import com.cn.tianxia.admin.project.txdata.Loginmap;
import com.cn.tianxia.admin.service.txdata.LoginmapService;

@Service
public class LoginmapServiceImpl implements LoginmapService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(LoginmapServiceImpl.class);
    
    @Autowired
    private LoginmapMapper loginmapMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return loginmapMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Loginmap record) {
        return loginmapMapper.insertSelective(record);
    }

    @Override
    public Loginmap selectByPrimaryKey(Integer id) {
        return loginmapMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Loginmap record) {
        return loginmapMapper.updateByPrimaryKeySelective(record);
    }
    
}
