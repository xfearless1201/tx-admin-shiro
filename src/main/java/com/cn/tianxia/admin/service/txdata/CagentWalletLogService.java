package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentWalletLog;

public interface CagentWalletLogService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentWalletLog record);

    CagentWalletLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentWalletLog record);
}
