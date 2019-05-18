package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.Ipwhitelist;

public interface IpwhitelistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ipwhitelist record);

    int insertSelective(Ipwhitelist record);

    Ipwhitelist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ipwhitelist record);

    int updateByPrimaryKey(Ipwhitelist record);
}