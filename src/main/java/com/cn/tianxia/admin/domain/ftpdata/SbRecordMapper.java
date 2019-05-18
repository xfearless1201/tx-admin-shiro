package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.SbRecord;

public interface SbRecordMapper extends GameRecordCommonMapper<SbRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(SbRecord record);

    int insertSelective(SbRecord record);

    SbRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SbRecord record);

    int updateByPrimaryKey(SbRecord record);
}