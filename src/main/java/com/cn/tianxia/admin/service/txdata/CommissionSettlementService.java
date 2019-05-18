package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CommissionSettlement;

public interface CommissionSettlementService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CommissionSettlement record);

    CommissionSettlement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommissionSettlement record);

}
