package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class WinningRecord {
    private Integer id;

    private Integer cid;

    private Integer activityId;

    private Integer uid;

    private Integer prizeId;

    private Integer amount;

    private Integer totalWinnings;

    private Date winningTime;

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

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotalWinnings() {
        return totalWinnings;
    }

    public void setTotalWinnings(Integer totalWinnings) {
        this.totalWinnings = totalWinnings;
    }

    public Date getWinningTime() {
        return winningTime;
    }

    public void setWinningTime(Date winningTime) {
        this.winningTime = winningTime;
    }
}