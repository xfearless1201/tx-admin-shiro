package com.cn.tianxia.admin.web.IntegralMall;

import com.cn.tianxia.admin.project.txdata.IntegralMall.OrderManage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hulk
 * @Date: 2019/5/8 15:47
 * @Description: 个人测试
 */

public class test {
    public static void main(String[] args) {
        OrderManage orderManage1 = new OrderManage();
        orderManage1.setId(1);
        OrderManage orderManage2 = new OrderManage();
        orderManage2.setCid(1);
        orderManage2.setCagentName("tianXia");
        List<OrderManage> a = new ArrayList<>();
        a.add(orderManage1);
        a.add(orderManage2);
        for (OrderManage or : a) {
            System.out.println(or.getId());
        }

    }
}
