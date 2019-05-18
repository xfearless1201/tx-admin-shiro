package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CardType;

public interface CardTypeMapper {
    int deleteByPrimaryKey(Integer bankId);

    int insert(CardType record);

    int insertSelective(CardType record);

    CardType selectByPrimaryKey(Integer bankId);

    int updateByPrimaryKeySelective(CardType record);

    int updateByPrimaryKey(CardType record);
}