package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.BackWaterConfigMapper;
import com.cn.tianxia.admin.project.txdata.BackWaterConfig;
import com.cn.tianxia.admin.service.txdata.BackWaterConfigService;

/**
 * 
 * @ClassName BackWaterConfigServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:08:56
 * @version 1.0.0
 */
@Service
public class BackWaterConfigServiceImpl implements BackWaterConfigService {
    
    //日志
    private static final Logger logger = LoggerFactory.getLogger(BackWaterConfigServiceImpl.class);
    
    @Autowired
    private BackWaterConfigMapper backWaterConfigMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return backWaterConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BackWaterConfig record) {
        return backWaterConfigMapper.insertSelective(record);
    }

    @Override
    public BackWaterConfig selectByPrimaryKey(Integer id) {
        return backWaterConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BackWaterConfig record) {
        return backWaterConfigMapper.updateByPrimaryKeySelective(record);
    }

    
}
