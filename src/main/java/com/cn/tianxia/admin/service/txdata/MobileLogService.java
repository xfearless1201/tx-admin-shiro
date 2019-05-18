package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.MobileLog;

public interface MobileLogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(MobileLog record);

    MobileLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MobileLog record);

}
