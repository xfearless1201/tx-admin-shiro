package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.ProxyFeeConfig;

public interface ProxyFeeConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProxyFeeConfig record);

    int insertSelective(ProxyFeeConfig record);

    ProxyFeeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxyFeeConfig record);

    int updateByPrimaryKey(ProxyFeeConfig record);
}