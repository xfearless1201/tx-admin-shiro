package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PrizeLevel;

public interface PrizeLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrizeLevel record);

    int insertSelective(PrizeLevel record);

    PrizeLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeLevel record);

    int updateByPrimaryKey(PrizeLevel record);
}