package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.WebcomImg;

public interface WebcomImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebcomImg record);

    int insertSelective(WebcomImg record);

    WebcomImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebcomImg record);

    int updateByPrimaryKey(WebcomImg record);
}