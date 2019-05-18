package com.cn.tianxia.admin.service.txdata.IntegralMallService.IntegralMallServiceImpl;

import com.cn.tianxia.admin.common.GoodsPager;
import com.cn.tianxia.admin.domain.txdata.IntegralMallMapper.GoodsInventoryMapper;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.GoodsInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/12 18:04
 * @Description: 商品库存serviceImpl
 */

@Service
public class GoodsInventoryServiceImpl implements GoodsInventoryService {

    @Autowired
    private GoodsInventoryMapper goodsInventoryMapper;

    @Override
    public GoodsPager<GoodsInventory> queryGoodsInventoryInfo(Map<String, String> params) {
        GoodsPager<GoodsInventory> pager = new GoodsPager<>(params);
        List<GoodsInventory> list = goodsInventoryMapper.pluInv(pager);
        int count = goodsInventoryMapper.pluInvROWS(pager);
        //添加小计
        String totalSmall = "小计";
        Integer totalNum = 0;
        Integer totalFreezeNum = 0;

        Map<String, Object> totalMap = new HashMap<String, Object>();
        for (GoodsInventory goodsInventory : list) {
            totalNum += goodsInventory.getNum();
            totalFreezeNum += goodsInventory.getFreezeNum();
        }

        pager.setTotalSmall(totalSmall);
        pager.setTotalFreezeNum(totalFreezeNum);
        pager.setTotalNum(totalNum);

        Map<String, Object> totalSum = goodsInventoryMapper.pluInvSum(params);
        if (totalSum == null) {
            totalSum = new HashMap();
            totalSum.put("num", 0);
            totalSum.put("freezeNum", 0);
            pager.setTotalNumSum(0);
            pager.setTotalFreezeNumSum(0);
        } else {
            pager.setTotalNumSum(Integer.parseInt(totalSum.get("num").toString()));
            pager.setTotalFreezeNum(Integer.parseInt(totalSum.get("freezeNum").toString()));
        }

        totalSum.put("pluname", "总计");
        pager.setPluname(totalSum.get("pluname").toString());

        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

    @Override
    public int updatePluInv(Map<String, Object> params) {
        return goodsInventoryMapper.updatePluInv(params);
    }

    @Override
    public int updatePluInvLog(Map<String, Object> params) {
        return goodsInventoryMapper.updatePluInvLog(params);
    }


}

