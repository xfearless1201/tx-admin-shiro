package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.SigninTemplate;

public interface SigninTemplateService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(SigninTemplate record);

    SigninTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SigninTemplate record);
}
