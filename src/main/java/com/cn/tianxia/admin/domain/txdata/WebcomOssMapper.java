package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.WebcomOss;

public interface WebcomOssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebcomOss record);

    int insertSelective(WebcomOss record);

    WebcomOss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebcomOss record);

    int updateByPrimaryKey(WebcomOss record);
}