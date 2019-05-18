package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.Transfer;
import org.apache.ibatis.annotations.Param;

public interface TransferMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    Transfer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Transfer record);

    int updateByPrimaryKey(Transfer record);

    Double getBalance(@Param("uid") Integer uid);
}