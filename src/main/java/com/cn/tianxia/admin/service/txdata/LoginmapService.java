package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Loginmap;

public interface LoginmapService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Loginmap record);

    Loginmap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginmap record);

}
