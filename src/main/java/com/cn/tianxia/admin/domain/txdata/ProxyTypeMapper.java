package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.ProxyType;

public interface ProxyTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProxyType record);

    int insertSelective(ProxyType record);

    ProxyType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxyType record);

    int updateByPrimaryKey(ProxyType record);
}