package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PayChannel;

public interface PayChannelService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PayChannel record);

    PayChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayChannel record);

}
