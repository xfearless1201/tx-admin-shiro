package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PrizeLevel;

public interface PrizeLevelService {
    
    int deleteByPrimaryKey(Integer id);

    int insertSelective(PrizeLevel record);

    PrizeLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeLevel record);
}
