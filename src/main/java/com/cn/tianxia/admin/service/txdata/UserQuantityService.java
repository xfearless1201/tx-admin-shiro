package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserQuantity;

public interface UserQuantityService {
    
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserQuantity record);

    UserQuantity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserQuantity record);
}
