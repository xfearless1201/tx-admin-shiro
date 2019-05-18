package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentPayer;

public interface CagentPayerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentPayer record);

    int insertSelective(CagentPayer record);

    CagentPayer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentPayer record);

    int updateByPrimaryKey(CagentPayer record);
}