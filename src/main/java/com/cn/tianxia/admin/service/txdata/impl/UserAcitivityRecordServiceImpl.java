package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserAcitivityRecordMapper;
import com.cn.tianxia.admin.project.txdata.UserAcitivityRecord;
import com.cn.tianxia.admin.service.txdata.UserAcitivityRecordService;

import java.util.List;
import java.util.Map;

@Service
public class UserAcitivityRecordServiceImpl implements UserAcitivityRecordService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserAcitivityRecordServiceImpl.class);
    
    @Autowired
    private UserAcitivityRecordMapper userAcitivityRecordMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return userAcitivityRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserAcitivityRecord record) {
        return userAcitivityRecordMapper.insertSelective(record);
    }

    @Override
    public UserAcitivityRecord selectByPrimaryKey(Long id) {
        return userAcitivityRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAcitivityRecord record) {
        return userAcitivityRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<UserAcitivityRecord> list(Map<String, String> params) {
        Pager<UserAcitivityRecord> pager = new Pager<>(params);
        List<UserAcitivityRecord> list = userAcitivityRecordMapper.selectAllByPage(pager);
        int count = userAcitivityRecordMapper.selectTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

}
