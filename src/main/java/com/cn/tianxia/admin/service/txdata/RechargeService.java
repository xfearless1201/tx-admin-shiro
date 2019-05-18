package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Recharge;

public interface RechargeService {

    int deleteByPrimaryKey(Integer rId);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Recharge record);
}
