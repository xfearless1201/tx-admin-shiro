package com.cn.tianxia.admin.game.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zed
 * @Date: 2019/5/5 14:45
 * @Description: 游戏基础信息类
 */
@Data
public class TransferBaseInfo implements Serializable {

    private static final long serialVersionUID = 5642135487645221237L;

    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 平台id cid
     */
    private String cid;
    /**
     * 平台号
     */
    private String cagent;
    /**
     * 游戏登录账号
     */
    private String ag_username;
    /**
     * 皇冠体育
     */
    private String hg_username;
    /**
     * 游戏登录密码
     */
    private String ag_password;
    /**
     * 转账金额
     */
    private String credit;
    /**
     * 游戏平台编码
     */
    private String gameType;
    /**
     * ip
     */
    private String ip;
    /**
     * 转账类型 true 转入（平台到游戏） false 转出（游戏到平台）
     */
    private Boolean transferType;
    /**
     * 游戏id
     */
    private String gameId;
    /**
     * model
     */
    private String model;
    /**
     * 来源url
     */
    private String refererUrl;
    /**
     * 游戏配置
     */
    private JSONObject config;
    /**
     * 转账订单号
     */
    private String billno;
    /**
     * 盘口
     */
    private String handicap;

}
