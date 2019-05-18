package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CardTypeMapper;
import com.cn.tianxia.admin.project.txdata.CardType;
import com.cn.tianxia.admin.service.txdata.CardTypeService;

@Service
public class CardTypeServiceImpl implements CardTypeService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CardTypeServiceImpl.class);

    @Autowired
    private CardTypeMapper cardTypeMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer bankId) {
        return cardTypeMapper.deleteByPrimaryKey(bankId);
    }

    @Override
    public int insertSelective(CardType record) {
        return cardTypeMapper.insertSelective(record);
    }

    @Override
    public CardType selectByPrimaryKey(Integer bankId) {
        return cardTypeMapper.selectByPrimaryKey(bankId);
    }

    @Override
    public int updateByPrimaryKeySelective(CardType record) {
        return cardTypeMapper.updateByPrimaryKeySelective(record);
    }
}
