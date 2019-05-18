package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.JuniorProxyType;

public interface JuniorProxyTypeService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(JuniorProxyType record);

    JuniorProxyType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JuniorProxyType record);

}
