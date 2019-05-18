package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.WinningRecordMapper;
import com.cn.tianxia.admin.project.txdata.WinningRecord;
import com.cn.tianxia.admin.service.txdata.WinningRecordService;

@Service
public class WinningRecordServiceImpl implements WinningRecordService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(WinningRecordServiceImpl.class);
    
    @Autowired
    private WinningRecordMapper winningRecordMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return winningRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(WinningRecord record) {
        return winningRecordMapper.insertSelective(record);
    }

    @Override
    public WinningRecord selectByPrimaryKey(Integer id) {
        return winningRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WinningRecord record) {
        return winningRecordMapper.updateByPrimaryKeySelective(record);
    }

}
