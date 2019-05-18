package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserTreasure;

public interface UserTreasureService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserTreasure record);

    UserTreasure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTreasure record);

}
