package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentWalletLog;

public interface CagentWalletLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentWalletLog record);

    int insertSelective(CagentWalletLog record);

    CagentWalletLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentWalletLog record);

    int updateByPrimaryKey(CagentWalletLog record);
}