package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PlatformGamesList;

public interface PlatformGamesListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformGamesList record);

    int insertSelective(PlatformGamesList record);

    PlatformGamesList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformGamesList record);

    int updateByPrimaryKey(PlatformGamesList record);
}