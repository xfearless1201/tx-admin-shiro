package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.ProxySettlement;

public interface ProxySettlementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProxySettlement record);

    int insertSelective(ProxySettlement record);

    ProxySettlement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxySettlement record);

    int updateByPrimaryKey(ProxySettlement record);
}