package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentWallet;

public interface CagentWalletService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentWallet record);

    CagentWallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentWallet record);
}
