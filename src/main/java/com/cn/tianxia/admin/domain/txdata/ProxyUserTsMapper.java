package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.ProxyUserTs;

public interface ProxyUserTsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProxyUserTs record);

    int insertSelective(ProxyUserTs record);

    ProxyUserTs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxyUserTs record);

    int updateByPrimaryKey(ProxyUserTs record);
}