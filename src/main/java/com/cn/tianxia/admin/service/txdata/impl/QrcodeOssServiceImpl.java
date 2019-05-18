package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.QrcodeOssMapper;
import com.cn.tianxia.admin.project.txdata.QrcodeOss;
import com.cn.tianxia.admin.service.txdata.QrcodeOssService;

@Service
public class QrcodeOssServiceImpl implements QrcodeOssService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(QrcodeOssServiceImpl.class);
    
    @Autowired
    private QrcodeOssMapper qrcodeOssMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return qrcodeOssMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(QrcodeOss record) {
        return qrcodeOssMapper.insertSelective(record);
    }

    @Override
    public QrcodeOss selectByPrimaryKey(Integer id) {
        return qrcodeOssMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(QrcodeOss record) {
        return qrcodeOssMapper.updateByPrimaryKeySelective(record);
    }

}
