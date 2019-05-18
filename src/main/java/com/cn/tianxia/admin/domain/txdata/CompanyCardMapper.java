package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CompanyCard;

public interface CompanyCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyCard record);

    int insertSelective(CompanyCard record);

    CompanyCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyCard record);

    int updateByPrimaryKey(CompanyCard record);
}