package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class LotteryRecord {
    private Integer id;

    private Integer cid;

    private Integer activityId;

    private Integer uid;

    private Date lotteryTime;

    private Integer totalCount;

    private Integer totalIntegral;

    private Integer isWinning;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(Date lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(Integer totalIntegral) {
        this.totalIntegral = totalIntegral;
    }

    public Integer getIsWinning() {
        return isWinning;
    }

    public void setIsWinning(Integer isWinning) {
        this.isWinning = isWinning;
    }
}