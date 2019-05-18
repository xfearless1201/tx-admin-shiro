package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.IBCSportRecord;

public interface IBCSportRecordMapper extends GameRecordCommonMapper<IBCSportRecord>{
    int deleteByPrimaryKey(Long id);

    int insert(IBCSportRecord record);

    int insertSelective(IBCSportRecord record);

    IBCSportRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IBCSportRecord record);

    int updateByPrimaryKey(IBCSportRecord record);
}