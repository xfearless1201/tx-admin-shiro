package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class PlatformLogin {
    private Integer id;

    private String pLoginName;

    private String pPassword;

    private String pName;

    private Integer pRole;

    private Integer pStatus;

    private Integer pPid;

    private String pIp;

    private String pUrl;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private String pRmk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpLoginName() {
        return pLoginName;
    }

    public void setpLoginName(String pLoginName) {
        this.pLoginName = pLoginName == null ? null : pLoginName.trim();
    }

    public String getpPassword() {
        return pPassword;
    }

    public void setpPassword(String pPassword) {
        this.pPassword = pPassword == null ? null : pPassword.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpRole() {
        return pRole;
    }

    public void setpRole(Integer pRole) {
        this.pRole = pRole;
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public Integer getpPid() {
        return pPid;
    }

    public void setpPid(Integer pPid) {
        this.pPid = pPid;
    }

    public String getpIp() {
        return pIp;
    }

    public void setpIp(String pIp) {
        this.pIp = pIp == null ? null : pIp.trim();
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl == null ? null : pUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getpRmk() {
        return pRmk;
    }

    public void setpRmk(String pRmk) {
        this.pRmk = pRmk == null ? null : pRmk.trim();
    }
}