package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ReserveAccount;

public interface ReserveAccountService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ReserveAccount record);

    ReserveAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReserveAccount record);
}
