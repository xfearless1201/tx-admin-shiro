package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PluCate;

public interface PluCateService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PluCate record);

    PluCate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PluCate record);
}
