package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.JuniorProxyUserTs;

public interface JuniorProxyUserTsService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(JuniorProxyUserTs record);

    JuniorProxyUserTs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JuniorProxyUserTs record);

}
