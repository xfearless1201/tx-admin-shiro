package com.cn.tianxia.admin.service.txdata.IntegralMallService.IntegralMallServiceImpl;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.IntegralMallMapper.InventoryRecordMapper;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.InventoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/14 18:25
 * @Description: 库存流水serviceImpl
 */
@Service
public class InventoryRecordServiceImpl implements InventoryRecordService {

    @Autowired
    InventoryRecordMapper inventoryRecordMapper;

    @Override
    public Pager<GoodsInventory> queryInventoryRecordInfo(Map<String, String> params) {
        Pager<GoodsInventory> pager = new Pager<>(params);
        List<GoodsInventory> list = inventoryRecordMapper.pluInvLog(pager);
        int count = inventoryRecordMapper.pluInvLogROWS(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }
}
