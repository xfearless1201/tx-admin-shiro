package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.AmountRecord;

public interface AmountRecordService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(AmountRecord record);

    AmountRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmountRecord record);
}
