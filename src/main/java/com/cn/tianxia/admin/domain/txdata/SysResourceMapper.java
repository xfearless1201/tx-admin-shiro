package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.SysResource;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);
}