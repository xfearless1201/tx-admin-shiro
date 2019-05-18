package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.WinningRecord;

public interface WinningRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WinningRecord record);

    int insertSelective(WinningRecord record);

    WinningRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WinningRecord record);

    int updateByPrimaryKey(WinningRecord record);
}