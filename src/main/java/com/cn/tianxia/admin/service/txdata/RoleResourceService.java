package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.RoleResource;

public interface RoleResourceService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResource record);
}
