package com.cn.tianxia.admin.domain.txdata.IntegralMallMapper;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;

import java.util.List;

/**
 * @Author: hulk
 * @Date: 2019/5/14 18:46
 * @Description: 库存流水dao
 */
public interface InventoryRecordMapper {
    List<GoodsInventory> pluInvLog(Pager pager);

    int pluInvLogROWS(Pager pager);
}
