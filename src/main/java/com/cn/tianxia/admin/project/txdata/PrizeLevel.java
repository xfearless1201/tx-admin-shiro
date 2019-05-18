package com.cn.tianxia.admin.project.txdata;

public class PrizeLevel {
    private Integer id;

    private Integer cid;

    private Integer activityId;

    private Integer prizeType;

    private Integer expendIntegral;

    private String rmk;

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

    public Integer getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }

    public Integer getExpendIntegral() {
        return expendIntegral;
    }

    public void setExpendIntegral(Integer expendIntegral) {
        this.expendIntegral = expendIntegral;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }
}