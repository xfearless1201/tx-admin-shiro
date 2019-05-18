package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserLuckrdrawLogMapper;
import com.cn.tianxia.admin.project.txdata.UserLuckrdrawLog;
import com.cn.tianxia.admin.service.txdata.UserLuckrdrawLogService;

import java.util.List;
import java.util.Map;

@Service
public class UserLuckrdrawLogServiceImpl implements UserLuckrdrawLogService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserLuckrdrawLogServiceImpl.class);
    
    @Autowired
    private UserLuckrdrawLogMapper userLuckrdrawLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userLuckrdrawLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserLuckrdrawLog record) {
        return userLuckrdrawLogMapper.insertSelective(record);
    }

    @Override
    public UserLuckrdrawLog selectByPrimaryKey(Integer id) {
        return userLuckrdrawLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserLuckrdrawLog record) {
        return userLuckrdrawLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<UserLuckrdrawLog> list(Map<String, String> params) {
        Pager<UserLuckrdrawLog> pager = new Pager<>(params);
        List<UserLuckrdrawLog> list = userLuckrdrawLogMapper.selectAllByPage(pager);
        int count = userLuckrdrawLogMapper.selectTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

}
