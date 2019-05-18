package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.MGGameRecord;

public interface MGGameRecordMapper extends GameRecordCommonMapper<MGGameRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(MGGameRecord record);

    int insertSelective(MGGameRecord record);

    MGGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MGGameRecord record);

    int updateByPrimaryKey(MGGameRecord record);
}