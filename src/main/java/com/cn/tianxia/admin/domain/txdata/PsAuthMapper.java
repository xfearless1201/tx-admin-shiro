package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PsAuth;

public interface PsAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PsAuth record);

    int insertSelective(PsAuth record);

    PsAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PsAuth record);

    int updateByPrimaryKey(PsAuth record);
}