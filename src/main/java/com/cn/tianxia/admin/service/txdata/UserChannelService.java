package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserChannel;

public interface UserChannelService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(UserChannel record);

    UserChannel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserChannel record);
}
