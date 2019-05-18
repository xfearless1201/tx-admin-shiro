package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.SigninTemplate;

public interface SigninTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SigninTemplate record);

    int insertSelective(SigninTemplate record);

    SigninTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SigninTemplate record);

    int updateByPrimaryKey(SigninTemplate record);
}