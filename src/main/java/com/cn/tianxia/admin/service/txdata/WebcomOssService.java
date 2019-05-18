package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.WebcomOss;

public interface WebcomOssService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(WebcomOss record);

    WebcomOss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebcomOss record);
}
