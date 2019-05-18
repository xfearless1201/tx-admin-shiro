package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentSettlement;

public interface CagentSettlementService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentSettlement record);

    CagentSettlement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentSettlement record);

}
