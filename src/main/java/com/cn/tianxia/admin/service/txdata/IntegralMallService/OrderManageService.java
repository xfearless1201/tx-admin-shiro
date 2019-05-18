package com.cn.tianxia.admin.service.txdata.IntegralMallService;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;
import com.cn.tianxia.admin.project.txdata.IntegralMall.OrderManage;

import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/14 18:23
 * @Description: 订单管理service
 */
public interface OrderManageService {
    Pager<OrderManage> queryOrderManageInfo(Map<String, String> params);

    int updateByPrimaryKeySelective(OrderManage orderManage);

    OrderManage selectByPrimaryKey(Integer id);

    int insert_auditOrder(OrderManage orderManage);
}
