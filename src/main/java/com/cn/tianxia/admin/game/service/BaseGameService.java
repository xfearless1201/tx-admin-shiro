package com.cn.tianxia.admin.game.service;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.game.enums.TransferResultEnum;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import com.cn.tianxia.admin.utils.DESEncrypt;
import com.cn.tianxia.admin.utils.MD5Utils;
import com.cn.tianxia.admin.utils.OkHttpUtils;
import okhttp3.Headers;

import java.util.Map;

/**
 * @Author: zed
 * @Date: 2019/5/5 10:33
 * @Description: 游戏类service基类
 */
public abstract class BaseGameService {

    public abstract void init(TransferBaseInfo baseInfo);

    public abstract JSONObject queryBalace(TransferBaseInfo baseInfo);

    public abstract JSONObject getLink(TransferBaseInfo baseInfo);

    public abstract TransferResultEnum transferIn(TransferBaseInfo baseInfo);

    public abstract TransferResultEnum transferOut(TransferBaseInfo baseInfo);

    public abstract JSONObject checkOrCreateAccount(TransferBaseInfo baseInfo);

    public abstract JSONObject queryTransferOrder(TransferBaseInfo baseInfo);

    protected String post(Map<String,String> params, String url, Headers headers) throws Exception {
        return OkHttpUtils.sendMapPost( url,params, headers);
    }

    protected String post(Map<String,String> params, String url) throws Exception{
        return OkHttpUtils.sendMapPost(url, params);
    }

    protected String postJson(String url, String json) throws Exception {
        return OkHttpUtils.sendJsonPost(url, json);
    }

    protected String postJson(String url, String json, Headers headers) throws Exception {
        return OkHttpUtils.sendJsonPost(url, json, headers);
    }

    protected String get(String url) throws Exception {
        return OkHttpUtils.sendGet(url);
    }

    protected String get(String url, Headers headers) throws Exception {
        return OkHttpUtils.sendGet(url, headers);
    }

    protected static String getAGUrl(String url, String xmlString, String deskey, String md5key) {
        String param = "";
        String tagUrl = "";
        String key = "";
        DESEncrypt d = new DESEncrypt(deskey);
        try {
            param = d.encrypt(xmlString);
            key = MD5Utils.md5toUpCase_32Bit(param + md5key);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        tagUrl = url + "params=" + param + "&key=" + key;
        return tagUrl;
    }
}
