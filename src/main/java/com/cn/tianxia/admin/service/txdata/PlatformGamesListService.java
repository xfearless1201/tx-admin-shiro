package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PlatformGamesList;

public interface PlatformGamesListService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(PlatformGamesList record);

    PlatformGamesList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformGamesList record);
}
