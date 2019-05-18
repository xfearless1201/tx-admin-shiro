package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserTypeHandicap;

public interface UserTypeHandicapService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserTypeHandicap record);

    UserTypeHandicap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTypeHandicap record);
}
