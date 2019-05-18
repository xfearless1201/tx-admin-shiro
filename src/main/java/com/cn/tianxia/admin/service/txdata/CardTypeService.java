package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CardType;

public interface CardTypeService {

    int deleteByPrimaryKey(Integer bankId);

    int insertSelective(CardType record);

    CardType selectByPrimaryKey(Integer bankId);

    int updateByPrimaryKeySelective(CardType record);

}
