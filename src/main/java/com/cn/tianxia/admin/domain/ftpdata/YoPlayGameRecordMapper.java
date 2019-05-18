package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.YoPlayGameRecord;

public interface YoPlayGameRecordMapper extends GameRecordCommonMapper<YoPlayGameRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(YoPlayGameRecord record);

    int insertSelective(YoPlayGameRecord record);

    YoPlayGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YoPlayGameRecord record);

    int updateByPrimaryKey(YoPlayGameRecord record);
}