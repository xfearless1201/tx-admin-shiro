package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.OnlinepayCallbackLog;

public interface OnlinepayCallbackLogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(OnlinepayCallbackLog record);

    OnlinepayCallbackLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnlinepayCallbackLog record);

}
