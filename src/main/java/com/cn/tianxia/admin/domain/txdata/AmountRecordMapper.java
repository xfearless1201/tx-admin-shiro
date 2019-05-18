package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.AmountRecord;

public interface AmountRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmountRecord record);

    int insertSelective(AmountRecord record);

    AmountRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmountRecord record);

    int updateByPrimaryKey(AmountRecord record);
}