package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PsAuth;

public interface PsAuthService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PsAuth record);

    PsAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PsAuth record);
}
