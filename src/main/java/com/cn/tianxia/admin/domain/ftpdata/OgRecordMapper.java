package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.OgRecord;

public interface OgRecordMapper extends GameRecordCommonMapper<OgRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(OgRecord record);

    int insertSelective(OgRecord record);

    OgRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OgRecord record);

    int updateByPrimaryKey(OgRecord record);
}