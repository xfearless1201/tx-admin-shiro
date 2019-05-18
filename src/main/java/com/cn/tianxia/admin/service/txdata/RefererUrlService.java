package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.RefererUrl;

public interface RefererUrlService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(RefererUrl record);

    RefererUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RefererUrl record);
}
