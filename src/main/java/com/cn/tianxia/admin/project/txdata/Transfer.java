package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class Transfer {
    private Integer id;

    private Integer uid;

    private String billno;

    private String username;

    private String tType;

    private Float tMoney;

    private Float oldMoney;

    private Float newMoney;

    private String type;

    private Date tTime;

    private String ip;

    private String result;

    private String cagent;

    private Integer cid;

    private Integer status;

    private String description;

    private Integer taskCounts;

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

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType == null ? null : tType.trim();
    }

    public Float gettMoney() {
        return tMoney;
    }

    public void settMoney(Float tMoney) {
        this.tMoney = tMoney;
    }

    public Float getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(Float oldMoney) {
        this.oldMoney = oldMoney;
    }

    public Float getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(Float newMoney) {
        this.newMoney = newMoney;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date gettTime() {
        return tTime;
    }

    public void settTime(Date tTime) {
        this.tTime = tTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getTaskCounts() {
        return taskCounts;
    }

    public void setTaskCounts(Integer taskCounts) {
        this.taskCounts = taskCounts;
    }
}