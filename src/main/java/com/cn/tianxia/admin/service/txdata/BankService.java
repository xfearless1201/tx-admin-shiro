package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Bank;

public interface BankService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Bank record);

    Bank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bank record);
}
