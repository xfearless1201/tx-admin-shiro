package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserWallet;


public interface UserWalletService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserWallet record);

    UserWallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWallet record);
}
