package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.AccountDaySum;

public interface AccountDaySumMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountDaySum record);

    int insertSelective(AccountDaySum record);

    AccountDaySum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountDaySum record);

    int updateByPrimaryKey(AccountDaySum record);
}