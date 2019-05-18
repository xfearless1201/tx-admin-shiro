package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PluInfo;

public interface PluInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PluInfo record);

    int insertSelective(PluInfo record);

    PluInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PluInfo record);

    int updateByPrimaryKey(PluInfo record);
}