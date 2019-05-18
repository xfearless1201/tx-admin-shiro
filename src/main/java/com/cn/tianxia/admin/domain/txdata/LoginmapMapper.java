package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.Loginmap;

public interface LoginmapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Loginmap record);

    int insertSelective(Loginmap record);

    Loginmap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginmap record);

    int updateByPrimaryKey(Loginmap record);
}