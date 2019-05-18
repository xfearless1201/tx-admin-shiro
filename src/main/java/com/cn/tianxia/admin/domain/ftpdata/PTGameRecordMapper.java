package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.PTGameRecord;

public interface PTGameRecordMapper extends GameRecordCommonMapper<PTGameRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(PTGameRecord record);

    int insertSelective(PTGameRecord record);

    PTGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PTGameRecord record);

    int updateByPrimaryKey(PTGameRecord record);
}