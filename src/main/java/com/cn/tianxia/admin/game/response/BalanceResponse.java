package com.cn.tianxia.admin.game.response;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: zed
 * @Date: 2019/5/10 13:49
 * @Description: 查询余额返回Json对象
 */
public class BalanceResponse {
    public static JSONObject queryBalaceSuccess(String balance) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","success");
        jsonObject.put("balance",balance);
        return jsonObject;
    }

    public static JSONObject queryBalaceFailed() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","faild");
        jsonObject.put("balance","0.00");
        return jsonObject;
    }
}
