package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.PSGameRecord;

public interface PSGameRecordMapper extends GameRecordCommonMapper<PSGameRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(PSGameRecord record);

    int insertSelective(PSGameRecord record);

    PSGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PSGameRecord record);

    int updateByPrimaryKeyWithBLOBs(PSGameRecord record);

    int updateByPrimaryKey(PSGameRecord record);
}