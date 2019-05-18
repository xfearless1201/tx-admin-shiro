package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserGamestatus;

public interface UserGamestatusService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserGamestatus record);

    UserGamestatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGamestatus record);
}
