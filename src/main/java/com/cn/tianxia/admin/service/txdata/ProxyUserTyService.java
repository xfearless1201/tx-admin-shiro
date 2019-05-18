package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ProxyUserTy;

public interface ProxyUserTyService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ProxyUserTy record);

    ProxyUserTy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxyUserTy record);
}
