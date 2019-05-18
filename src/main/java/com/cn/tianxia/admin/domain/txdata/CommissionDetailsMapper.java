package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CommissionDetails;

public interface CommissionDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommissionDetails record);

    int insertSelective(CommissionDetails record);

    CommissionDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommissionDetails record);

    int updateByPrimaryKey(CommissionDetails record);
}