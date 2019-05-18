package com.cn.tianxia.admin.service.txdata.IntegralMallService;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;

import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/14 18:23
 * @Description: 库存流水service
 */
public interface InventoryRecordService {
    Pager<GoodsInventory> queryInventoryRecordInfo(Map<String, String> params);
}
