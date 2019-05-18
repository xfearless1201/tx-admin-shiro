package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ProxyUserTs;

public interface ProxyUserTsService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ProxyUserTs record);

    ProxyUserTs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxyUserTs record);
}
