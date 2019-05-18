package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.WinningRecord;

public interface WinningRecordService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(WinningRecord record);

    WinningRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WinningRecord record);
}
