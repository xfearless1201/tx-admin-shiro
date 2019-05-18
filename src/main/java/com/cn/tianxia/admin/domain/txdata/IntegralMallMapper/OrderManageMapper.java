package com.cn.tianxia.admin.domain.txdata.IntegralMallMapper;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.OrderManage;

import java.util.List;

/**
 * @Author: hulk
 * @Date: 2019/5/14 18:46
 * @Description: 订单管理dao
 */
public interface OrderManageMapper {
    List<OrderManage> selectPluOrder(Pager pager);

    int selectPluOrderCount(Pager pager);

    int updateByPrimaryKeySelective(OrderManage rderManage);

    OrderManage selectByPrimaryKey(Integer id);
}
