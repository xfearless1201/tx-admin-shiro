package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.CgRecord;

public interface CgRecordMapper extends GameRecordCommonMapper<CgRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(CgRecord record);

    int insertSelective(CgRecord record);

    CgRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CgRecord record);

    int updateByPrimaryKey(CgRecord record);
}