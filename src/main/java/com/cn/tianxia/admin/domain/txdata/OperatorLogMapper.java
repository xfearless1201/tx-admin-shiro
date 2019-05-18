package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.OperatorLog;

public interface OperatorLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperatorLog record);

    int insertSelective(OperatorLog record);

    OperatorLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperatorLog record);

    int updateByPrimaryKey(OperatorLog record);
}