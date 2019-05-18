package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.HBGameRecord;

public interface HBGameRecordMapper extends GameRecordCommonMapper<HBGameRecord> {
    int deleteByPrimaryKey(Integer id);

    int insert(HBGameRecord record);

    int insertSelective(HBGameRecord record);

    HBGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HBGameRecord record);

    int updateByPrimaryKey(HBGameRecord record);
}