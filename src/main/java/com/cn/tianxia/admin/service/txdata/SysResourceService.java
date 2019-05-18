package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.SysResource;

public interface SysResourceService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResource record);
}
