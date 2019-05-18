package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.JuniorProxyType;

public interface JuniorProxyTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JuniorProxyType record);

    int insertSelective(JuniorProxyType record);

    JuniorProxyType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JuniorProxyType record);

    int updateByPrimaryKey(JuniorProxyType record);
}