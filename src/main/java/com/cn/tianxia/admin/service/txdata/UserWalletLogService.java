package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserWalletLog;

import java.util.Map;

public interface UserWalletLogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserWalletLog record);

    UserWalletLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWalletLog record);

    Pager<UserWalletLog> selectDataGrid(Map<String, String> params);
}
