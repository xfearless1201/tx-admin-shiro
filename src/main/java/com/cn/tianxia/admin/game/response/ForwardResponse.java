package com.cn.tianxia.admin.game.response;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: zed
 * @Date: 2019/5/10 14:14
 * @Description: 获取游戏链接返回json
 */
public class ForwardResponse {
    public static JSONObject forwardGameForm(String url) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", url);
        jsonObject.put("type","form");
        return jsonObject;
    }

    public static JSONObject forwardGameLink(String url) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", url);
        jsonObject.put("type","link");
        return jsonObject;
    }

    public static JSONObject forwardGameError() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "error");
        return jsonObject;
    }
}
