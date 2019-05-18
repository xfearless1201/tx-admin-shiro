package com.cn.tianxia.admin.service.txdata.IntegralMallService;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;

import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/12 18:04
 * @Description: 商品库存service
 */
public interface GoodsInventoryService {
    Pager<GoodsInventory> queryGoodsInventoryInfo(Map<String, String> params);

    int updatePluInv(Map<String, Object> params);

    int updatePluInvLog(Map<String, Object> params);
}
