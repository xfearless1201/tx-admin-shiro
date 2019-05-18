package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Fundmanage;

public interface FundmanageService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Fundmanage record);

    Fundmanage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fundmanage record);

}
