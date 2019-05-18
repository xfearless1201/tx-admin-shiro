package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.JuniorProxyUserTy;

public interface JuniorProxyUserTyService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(JuniorProxyUserTy record);

    JuniorProxyUserTy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JuniorProxyUserTy record);

}
