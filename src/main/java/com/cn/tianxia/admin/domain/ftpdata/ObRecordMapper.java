package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.ObRecord;

public interface ObRecordMapper extends GameRecordCommonMapper<ObRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(ObRecord record);

    int insertSelective(ObRecord record);

    ObRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ObRecord record);

    int updateByPrimaryKey(ObRecord record);
}