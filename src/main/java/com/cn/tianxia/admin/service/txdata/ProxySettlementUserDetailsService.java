package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ProxySettlementUserDetails;

public interface ProxySettlementUserDetailsService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ProxySettlementUserDetails record);

    ProxySettlementUserDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxySettlementUserDetails record);
}
