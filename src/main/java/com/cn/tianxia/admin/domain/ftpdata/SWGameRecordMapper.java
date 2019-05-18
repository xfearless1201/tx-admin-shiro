package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.SWGameRecord;

public interface SWGameRecordMapper extends GameRecordCommonMapper<SWGameRecord>{
    int deleteByPrimaryKey(Long id);

    int insert(SWGameRecord record);

    int insertSelective(SWGameRecord record);

    SWGameRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SWGameRecord record);

    int updateByPrimaryKey(SWGameRecord record);
}