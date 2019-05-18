package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.Fundmanage;

public interface FundmanageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fundmanage record);

    int insertSelective(Fundmanage record);

    Fundmanage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fundmanage record);

    int updateByPrimaryKey(Fundmanage record);
}