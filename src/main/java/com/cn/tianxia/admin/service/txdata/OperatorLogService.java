package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.OperatorLog;

public interface OperatorLogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(OperatorLog record);

    OperatorLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperatorLog record);

}
