package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.WebcomImg;

public interface WebcomImgService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(WebcomImg record);

    WebcomImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebcomImg record);
}
