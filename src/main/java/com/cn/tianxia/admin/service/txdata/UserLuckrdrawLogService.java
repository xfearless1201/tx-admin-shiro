package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserLuckrdrawLog;

import java.util.Map;

public interface UserLuckrdrawLogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserLuckrdrawLog record);

    UserLuckrdrawLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLuckrdrawLog record);

    Pager<UserLuckrdrawLog> list(Map<String,String> params);
}
