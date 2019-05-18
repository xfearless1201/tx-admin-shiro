package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.MobileLog;

public interface MobileLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MobileLog record);

    int insertSelective(MobileLog record);

    MobileLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MobileLog record);

    int updateByPrimaryKey(MobileLog record);
}