package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ContactConfig;

public interface ContactConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ContactConfig record);

    ContactConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContactConfig record);

}
