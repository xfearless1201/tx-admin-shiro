package com.cn.tianxia.admin.project.ftpdata;

import java.io.Serializable;

/**
 * 
 * @ClassName ResultCommonField
 * @Description TODO(查询结果中需要拼接的字段)
 * @author Hardy
 * @Date 2019年5月13日 下午5:25:46
 * @version 1.0.0
 */
public class ResultCommonField implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 真实姓名 
     */
    private String realName;
    
    /**
     * 游戏类型，比如龙虎，骰宝
     */
    private String gameTypeName;
    
    /**
     * 下注记录结果，比如 庄闲，龙虎
     */
    private String dataValue;

    /**
     * 奖金记录
     */
    private float prize;
    
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public void setGameTypeName(String gameTypeName) {
        this.gameTypeName = gameTypeName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }
    
}
