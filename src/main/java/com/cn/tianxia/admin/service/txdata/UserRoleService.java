package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserRole;

public interface UserRoleService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);
}
