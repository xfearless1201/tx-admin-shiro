package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class WashcodeConfig {
    private Integer id;

    private Integer uid;

    private Float washcodeProp;

    private Integer adduid;

    private Date addTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Float getWashcodeProp() {
        return washcodeProp;
    }

    public void setWashcodeProp(Float washcodeProp) {
        this.washcodeProp = washcodeProp;
    }

    public Integer getAdduid() {
        return adduid;
    }

    public void setAdduid(Integer adduid) {
        this.adduid = adduid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}