package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ConfigPay;

public interface ConfigPayService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ConfigPay record);

    ConfigPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigPay record);

}
