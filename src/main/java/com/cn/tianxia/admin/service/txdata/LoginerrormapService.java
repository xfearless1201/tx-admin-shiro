package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Loginerrormap;

public interface LoginerrormapService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Loginerrormap record);

    Loginerrormap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginerrormap record);

}
