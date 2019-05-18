package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.JDBGameRecord;

public interface JDBGameRecordMapper extends GameRecordCommonMapper<JDBGameRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(JDBGameRecord record);

    int insertSelective(JDBGameRecord record);

    JDBGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JDBGameRecord record);

    int updateByPrimaryKey(JDBGameRecord record);
}