package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PayChannel;

public interface PayChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayChannel record);

    int insertSelective(PayChannel record);

    PayChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayChannel record);

    int updateByPrimaryKey(PayChannel record);
}