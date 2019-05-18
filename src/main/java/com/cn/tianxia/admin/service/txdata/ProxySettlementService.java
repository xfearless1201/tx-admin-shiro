package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ProxySettlement;

public interface ProxySettlementService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ProxySettlement record);

    ProxySettlement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxySettlement record);
}
