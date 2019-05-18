package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Ipblacklist;

public interface IpblacklistService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Ipblacklist record);

    Ipblacklist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ipblacklist record);

}
