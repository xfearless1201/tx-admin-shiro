package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.ContactConfig;

public interface ContactConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactConfig record);

    int insertSelective(ContactConfig record);

    ContactConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContactConfig record);

    int updateByPrimaryKey(ContactConfig record);
}