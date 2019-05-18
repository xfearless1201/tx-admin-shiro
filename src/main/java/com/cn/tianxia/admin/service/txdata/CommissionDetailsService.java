package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CommissionDetails;

public interface CommissionDetailsService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CommissionDetails record);

    CommissionDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommissionDetails record);

}
