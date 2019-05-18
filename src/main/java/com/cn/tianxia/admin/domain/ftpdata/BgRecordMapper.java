package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.BgRecord;

public interface BgRecordMapper extends GameRecordCommonMapper<BgRecord> {
    int deleteByPrimaryKey(Integer id);

    int insert(BgRecord record);

    int insertSelective(BgRecord record);

    BgRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BgRecord record);

    int updateByPrimaryKey(BgRecord record);
}