package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentSettlement;

public interface CagentSettlementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentSettlement record);

    int insertSelective(CagentSettlement record);

    CagentSettlement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentSettlement record);

    int updateByPrimaryKey(CagentSettlement record);
}