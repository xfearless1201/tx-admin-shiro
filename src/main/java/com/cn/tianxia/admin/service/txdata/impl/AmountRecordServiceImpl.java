package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.AmountRecordMapper;
import com.cn.tianxia.admin.project.txdata.AmountRecord;
import com.cn.tianxia.admin.service.txdata.AmountRecordService;

/**
 * 
 * @ClassName AmountRecordServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:06:17
 * @version 1.0.0
 */
@Service
public class AmountRecordServiceImpl implements AmountRecordService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(AmountRecordServiceImpl.class);
    
    @Autowired
    private AmountRecordMapper amountRecordMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return amountRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(AmountRecord record) {
        return amountRecordMapper.insertSelective(record);
    }

    @Override
    public AmountRecord selectByPrimaryKey(Integer id) {
        return amountRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AmountRecord record) {
        return amountRecordMapper.updateByPrimaryKeySelective(record);
    }

}
