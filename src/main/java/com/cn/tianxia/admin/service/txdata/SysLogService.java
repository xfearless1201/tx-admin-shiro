package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.SysLogInfo;

public interface SysLogService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysLogInfo record);

    SysLogInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLogInfo record);
}
