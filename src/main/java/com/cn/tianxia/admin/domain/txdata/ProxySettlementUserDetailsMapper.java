package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.ProxySettlementUserDetails;

public interface ProxySettlementUserDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProxySettlementUserDetails record);

    int insertSelective(ProxySettlementUserDetails record);

    ProxySettlementUserDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxySettlementUserDetails record);

    int updateByPrimaryKey(ProxySettlementUserDetails record);
}