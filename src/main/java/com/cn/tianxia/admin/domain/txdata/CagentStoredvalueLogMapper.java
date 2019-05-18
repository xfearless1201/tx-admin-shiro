package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentStoredvalueLog;

public interface CagentStoredvalueLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentStoredvalueLog record);

    int insertSelective(CagentStoredvalueLog record);

    CagentStoredvalueLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentStoredvalueLog record);

    int updateByPrimaryKey(CagentStoredvalueLog record);
}