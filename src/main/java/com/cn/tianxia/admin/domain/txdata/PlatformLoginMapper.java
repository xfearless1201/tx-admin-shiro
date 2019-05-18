package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PlatformLogin;

public interface PlatformLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatformLogin record);

    int insertSelective(PlatformLogin record);

    PlatformLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformLogin record);

    int updateByPrimaryKey(PlatformLogin record);
}