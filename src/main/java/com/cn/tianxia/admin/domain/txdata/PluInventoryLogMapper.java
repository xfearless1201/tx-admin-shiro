package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PluInventoryLog;

public interface PluInventoryLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PluInventoryLog record);

    int insertSelective(PluInventoryLog record);

    PluInventoryLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PluInventoryLog record);

    int updateByPrimaryKey(PluInventoryLog record);
}