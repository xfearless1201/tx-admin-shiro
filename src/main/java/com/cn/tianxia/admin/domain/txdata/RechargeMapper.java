package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.Recharge;

public interface RechargeMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);
}