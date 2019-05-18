package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.CQJGameRecord;

public interface CQJGameRecordMapper extends GameRecordCommonMapper<CQJGameRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(CQJGameRecord record);

    int insertSelective(CQJGameRecord record);

    CQJGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CQJGameRecord record);

    int updateByPrimaryKey(CQJGameRecord record);
}