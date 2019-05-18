package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.SysLogInfo;

public interface SysLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLogInfo record);

    int insertSelective(SysLogInfo record);

    SysLogInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLogInfo record);

    int updateByPrimaryKey(SysLogInfo record);
}