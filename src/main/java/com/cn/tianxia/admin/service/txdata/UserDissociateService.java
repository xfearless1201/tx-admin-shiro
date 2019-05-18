package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserDissociate;

public interface UserDissociateService {

    int deleteByPrimaryKey(Integer uid);

    int insertSelective(UserDissociate record);

    UserDissociate selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserDissociate record);
}
