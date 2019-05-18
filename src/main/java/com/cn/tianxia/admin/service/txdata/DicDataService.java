package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.DicData;

public interface DicDataService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(DicData record);

    DicData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DicData record);
}
