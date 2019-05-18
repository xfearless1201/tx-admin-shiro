package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.WebcomConfig;

public interface WebcomConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(WebcomConfig record);

    WebcomConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebcomConfig record);
}
