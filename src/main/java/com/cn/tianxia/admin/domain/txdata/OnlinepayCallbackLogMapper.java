package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.OnlinepayCallbackLog;

public interface OnlinepayCallbackLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OnlinepayCallbackLog record);

    int insertSelective(OnlinepayCallbackLog record);

    OnlinepayCallbackLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnlinepayCallbackLog record);

    int updateByPrimaryKey(OnlinepayCallbackLog record);
}