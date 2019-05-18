package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PluInventoryLog;

public interface PluInventoryLogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PluInventoryLog record);

    PluInventoryLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PluInventoryLog record);
}
