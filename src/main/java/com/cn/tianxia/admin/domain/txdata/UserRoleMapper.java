package com.cn.tianxia.admin.domain.txdata;

import org.apache.ibatis.annotations.Param;

import com.cn.tianxia.admin.project.txdata.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    
    int updateByUserId(@Param("userId") Long userId,@Param("roleId") Long roleId);
}