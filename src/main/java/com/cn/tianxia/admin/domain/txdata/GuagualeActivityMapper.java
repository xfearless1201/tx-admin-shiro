package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.GuagualeActivity;

public interface GuagualeActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GuagualeActivity record);

    int insertSelective(GuagualeActivity record);

    GuagualeActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GuagualeActivity record);

    int updateByPrimaryKey(GuagualeActivity record);
}