package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CommissionSettlement;

public interface CommissionSettlementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommissionSettlement record);

    int insertSelective(CommissionSettlement record);

    CommissionSettlement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommissionSettlement record);

    int updateByPrimaryKey(CommissionSettlement record);
}