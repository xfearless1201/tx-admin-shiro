package com.cn.tianxia.admin.domain.txdata.IntegralMallMapper;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;
import com.cn.tianxia.admin.project.txdata.IntegralMall.OrderManage;

import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/12 18:06
 * @Description: 商品库存dao
 */
public interface GoodsInventoryMapper {
    List<GoodsInventory> pluInv(Pager pager);

    int pluInvROWS(Pager pager);

    Map<String, Object> pluInvSum(Map<String, String> params);

    int updatePluInv(Map<String, Object> params);

    int updatePluInvLog(Map<String, Object> params);

    //更新库存数量和冻结数量
    void updateStore(Map<String, Object> params);

    int updateByPrimaryKeySelective(OrderManage orderManage);
}
