package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentStoredvalueLog;

public interface CagentStoredvalueLogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentStoredvalueLog record);

    CagentStoredvalueLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentStoredvalueLog record);

}
