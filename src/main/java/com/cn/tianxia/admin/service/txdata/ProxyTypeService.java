package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ProxyType;

public interface ProxyTypeService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ProxyType record);

    ProxyType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxyType record);
}
