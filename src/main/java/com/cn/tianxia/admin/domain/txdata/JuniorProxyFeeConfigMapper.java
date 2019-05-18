package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.JuniorProxyFeeConfig;

public interface JuniorProxyFeeConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JuniorProxyFeeConfig record);

    int insertSelective(JuniorProxyFeeConfig record);

    JuniorProxyFeeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JuniorProxyFeeConfig record);

    int updateByPrimaryKey(JuniorProxyFeeConfig record);
}