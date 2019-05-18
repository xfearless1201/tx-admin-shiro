package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.WebcomConfig;

public interface WebcomConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebcomConfig record);

    int insertSelective(WebcomConfig record);

    WebcomConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebcomConfig record);

    int updateByPrimaryKey(WebcomConfig record);
}