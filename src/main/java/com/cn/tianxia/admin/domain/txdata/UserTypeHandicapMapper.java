package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserTypeHandicap;

public interface UserTypeHandicapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTypeHandicap record);

    int insertSelective(UserTypeHandicap record);

    UserTypeHandicap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTypeHandicap record);

    int updateByPrimaryKey(UserTypeHandicap record);
}