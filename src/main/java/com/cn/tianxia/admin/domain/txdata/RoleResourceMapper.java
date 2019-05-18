package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.tianxia.admin.project.txdata.RoleResource;

public interface RoleResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);
    
    List<Long> findAllResourceIdsByRoleId(Long roleId);
    
    //批量写入资源信息
    int batchInsertRoleResource(@Param("list") List<RoleResource> list);
    
    //批量删除角色资源关联信息
    int batchDeleteByRoleId(Long roleId);
}