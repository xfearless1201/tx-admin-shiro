package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PluOrder;

public interface PluOrderService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PluOrder record);

    PluOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PluOrder record);
}
