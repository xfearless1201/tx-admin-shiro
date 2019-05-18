package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Ipwhitelist;

public interface IpwhitelistService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Ipwhitelist record);

    Ipwhitelist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ipwhitelist record);

}
