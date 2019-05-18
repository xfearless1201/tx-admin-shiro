package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PlatformLogin;

public interface PlatformLoginService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PlatformLogin record);

    PlatformLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformLogin record);

}
