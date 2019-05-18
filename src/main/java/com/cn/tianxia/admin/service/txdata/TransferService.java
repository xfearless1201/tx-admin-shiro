package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Transfer;

public interface TransferService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Transfer record);

    Transfer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Transfer record);
}
