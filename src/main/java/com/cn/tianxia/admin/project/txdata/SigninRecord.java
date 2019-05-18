package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class SigninRecord {
    private Integer id;

    private Integer cid;

    private String username;

    private Integer continuousMax;

    private Integer checkinDays;

    private Date checkinOnDate;

    private Date checkinAtlastDate;

    private Integer whether;

    private Integer checkinIntegral;

    private Integer checkinGrandTotal;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getContinuousMax() {
        return continuousMax;
    }

    public void setContinuousMax(Integer continuousMax) {
        this.continuousMax = continuousMax;
    }

    public Integer getCheckinDays() {
        return checkinDays;
    }

    public void setCheckinDays(Integer checkinDays) {
        this.checkinDays = checkinDays;
    }

    public Date getCheckinOnDate() {
        return checkinOnDate;
    }

    public void setCheckinOnDate(Date checkinOnDate) {
        this.checkinOnDate = checkinOnDate;
    }

    public Date getCheckinAtlastDate() {
        return checkinAtlastDate;
    }

    public void setCheckinAtlastDate(Date checkinAtlastDate) {
        this.checkinAtlastDate = checkinAtlastDate;
    }

    public Integer getWhether() {
        return whether;
    }

    public void setWhether(Integer whether) {
        this.whether = whether;
    }

    public Integer getCheckinIntegral() {
        return checkinIntegral;
    }

    public void setCheckinIntegral(Integer checkinIntegral) {
        this.checkinIntegral = checkinIntegral;
    }

    public Integer getCheckinGrandTotal() {
        return checkinGrandTotal;
    }

    public void setCheckinGrandTotal(Integer checkinGrandTotal) {
        this.checkinGrandTotal = checkinGrandTotal;
    }
}