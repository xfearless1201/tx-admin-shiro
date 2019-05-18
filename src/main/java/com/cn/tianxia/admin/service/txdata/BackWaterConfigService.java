package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.BackWaterConfig;

public interface BackWaterConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(BackWaterConfig record);

    BackWaterConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackWaterConfig record);
}
