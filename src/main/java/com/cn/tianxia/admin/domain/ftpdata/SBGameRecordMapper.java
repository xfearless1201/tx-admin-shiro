package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.SBGameRecord;

public interface SBGameRecordMapper extends GameRecordCommonMapper<SBGameRecord> {
    int deleteByPrimaryKey(Integer id);

    int insert(SBGameRecord record);

    int insertSelective(SBGameRecord record);

    SBGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SBGameRecord record);

    int updateByPrimaryKey(SBGameRecord record);
}