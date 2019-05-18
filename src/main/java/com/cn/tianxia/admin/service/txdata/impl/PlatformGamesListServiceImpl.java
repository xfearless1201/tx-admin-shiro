package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PlatformGamesListMapper;
import com.cn.tianxia.admin.project.txdata.PlatformGamesList;
import com.cn.tianxia.admin.service.txdata.PlatformGamesListService;

@Service
public class PlatformGamesListServiceImpl implements PlatformGamesListService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PlatformGamesListServiceImpl.class);
    
    @Autowired
    private PlatformGamesListMapper platformGamesListMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return platformGamesListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PlatformGamesList record) {
        return platformGamesListMapper.insertSelective(record);
    }

    @Override
    public PlatformGamesList selectByPrimaryKey(Long id) {
        return platformGamesListMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PlatformGamesList record) {
        return platformGamesListMapper.updateByPrimaryKeySelective(record);
    }

}
