package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.TransferFaild;

public interface TransferFaildService {
    
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TransferFaild record);

    TransferFaild selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransferFaild record);

}
