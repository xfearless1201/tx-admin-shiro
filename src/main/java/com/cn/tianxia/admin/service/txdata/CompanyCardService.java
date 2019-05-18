package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CompanyCard;

public interface CompanyCardService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CompanyCard record);

    CompanyCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyCard record);

}
