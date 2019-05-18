package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentPay;

public interface CagentPayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentPay record);

    int insertSelective(CagentPay record);

    CagentPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentPay record);

    int updateByPrimaryKey(CagentPay record);
}