package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.DsRecord;

public interface DsRecordMapper extends GameRecordCommonMapper<DsRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(DsRecord record);

    int insertSelective(DsRecord record);

    DsRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DsRecord record);

    int updateByPrimaryKey(DsRecord record);
}