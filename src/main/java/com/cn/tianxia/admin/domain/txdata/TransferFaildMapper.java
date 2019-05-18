package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.TransferFaild;

public interface TransferFaildMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TransferFaild record);

    int insertSelective(TransferFaild record);

    TransferFaild selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransferFaild record);

    int updateByPrimaryKey(TransferFaild record);
}