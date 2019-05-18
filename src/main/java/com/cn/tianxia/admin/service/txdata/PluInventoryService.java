package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PluInventory;

public interface PluInventoryService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PluInventory record);

    PluInventory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PluInventory record);
}
