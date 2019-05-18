package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.RefererUrl;

public interface RefererUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RefererUrl record);

    int insertSelective(RefererUrl record);

    RefererUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RefererUrl record);

    int updateByPrimaryKey(RefererUrl record);
}