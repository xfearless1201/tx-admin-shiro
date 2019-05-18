package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

public class BbinJpPrizeRecord {
    private Integer id;

    private String wagersid;

    private Integer jptypeid;

    private String username;

    private Date wagersdate;

    private Float jpamount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWagersid() {
        return wagersid;
    }

    public void setWagersid(String wagersid) {
        this.wagersid = wagersid == null ? null : wagersid.trim();
    }

    public Integer getJptypeid() {
        return jptypeid;
    }

    public void setJptypeid(Integer jptypeid) {
        this.jptypeid = jptypeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getWagersdate() {
        return wagersdate;
    }

    public void setWagersdate(Date wagersdate) {
        this.wagersdate = wagersdate;
    }

    public Float getJpamount() {
        return jpamount;
    }

    public void setJpamount(Float jpamount) {
        this.jpamount = jpamount;
    }
}