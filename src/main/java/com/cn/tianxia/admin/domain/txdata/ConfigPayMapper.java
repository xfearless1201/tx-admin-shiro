package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.ConfigPay;

public interface ConfigPayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfigPay record);

    int insertSelective(ConfigPay record);

    ConfigPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigPay record);

    int updateByPrimaryKey(ConfigPay record);
}