package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PluInfo;

public interface PluInfoService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PluInfo record);

    PluInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PluInfo record);
}
