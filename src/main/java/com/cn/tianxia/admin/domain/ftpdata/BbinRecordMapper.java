package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.BbinRecord;

public interface BbinRecordMapper extends GameRecordCommonMapper<BbinRecord>{
    
    int deleteByPrimaryKey(Integer id);

    int insert(BbinRecord record);

    int insertSelective(BbinRecord record);

    BbinRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbinRecord record);

    int updateByPrimaryKey(BbinRecord record);
}