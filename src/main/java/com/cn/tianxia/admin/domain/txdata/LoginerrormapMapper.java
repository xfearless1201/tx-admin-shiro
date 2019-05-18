package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.Loginerrormap;

public interface LoginerrormapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Loginerrormap record);

    int insertSelective(Loginerrormap record);

    Loginerrormap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginerrormap record);

    int updateByPrimaryKey(Loginerrormap record);
}