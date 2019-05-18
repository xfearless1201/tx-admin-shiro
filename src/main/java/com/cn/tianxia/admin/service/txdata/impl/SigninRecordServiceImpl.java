package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.SigninRecordMapper;
import com.cn.tianxia.admin.project.txdata.SigninRecord;
import com.cn.tianxia.admin.service.txdata.SigninRecordService;

import java.util.List;
import java.util.Map;

@Service
public class SigninRecordServiceImpl implements SigninRecordService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(SigninRecordServiceImpl.class);
    
    @Autowired
    private SigninRecordMapper signinRecordMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return signinRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SigninRecord record) {
        return signinRecordMapper.insertSelective(record);
    }

    @Override
    public SigninRecord selectByPrimaryKey(Integer id) {
        return signinRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SigninRecord record) {
        return signinRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<SigninRecord> list(Map<String, String> params) {
        Pager<SigninRecord> pager = new Pager<>(params);
        List<SigninRecord> list = signinRecordMapper.selectAllRecordByPage(pager);
        int count = signinRecordMapper.selectTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }
}
