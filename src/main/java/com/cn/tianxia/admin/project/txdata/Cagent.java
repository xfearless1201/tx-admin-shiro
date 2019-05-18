package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;

public class Cagent {
    private Integer id;

    @NotEmpty(message="平台编码不能为空")
    private String code;

    @Min(value=1,message="线路费用最小值为1")
    private Float lineCost;
    
    @NotEmpty(message="代理号不能为空")
    private String cagent;

    @NotEmpty(message="代理商称呼不能为空")
    private String name;

    @NotEmpty(message="代理商类型不能为空")
    private String type;
    
    private String rmk;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date addtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date upLineTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date expirationTime;

    @NotEmpty(message="网站域名不能为空")
    private String domain;

    @NotEmpty(message="手机端域名不能为空")
    private String mobileDomain;

    private Integer status;//0 正常 1 冻结(停用) 2废除

    @Min(value=1,message="初始储值额度不能小于1")
    private Float storedvalue;

    private Float storedratio;

    private String announcement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Float getLineCost() {
        return lineCost;
    }

    public void setLineCost(Float lineCost) {
        this.lineCost = lineCost;
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpLineTime() {
        return upLineTime;
    }

    public void setUpLineTime(Date upLineTime) {
        this.upLineTime = upLineTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getMobileDomain() {
        return mobileDomain;
    }

    public void setMobileDomain(String mobileDomain) {
        this.mobileDomain = mobileDomain == null ? null : mobileDomain.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getStoredvalue() {
        return storedvalue;
    }

    public void setStoredvalue(Float storedvalue) {
        this.storedvalue = storedvalue;
    }

    public Float getStoredratio() {
        return storedratio;
    }

    public void setStoredratio(Float storedratio) {
        this.storedratio = storedratio;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement == null ? null : announcement.trim();
    }
}