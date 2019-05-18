package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Withdraw;

public interface WithdrawService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Withdraw record);

    Withdraw selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Withdraw record);

}
