package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserCard;

public interface UserCardService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserCard record);

    UserCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCard record);
}
