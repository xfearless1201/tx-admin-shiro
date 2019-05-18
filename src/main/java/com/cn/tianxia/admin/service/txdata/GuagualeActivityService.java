package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.GuagualeActivity;

public interface GuagualeActivityService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(GuagualeActivity record);

    GuagualeActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GuagualeActivity record);

}
