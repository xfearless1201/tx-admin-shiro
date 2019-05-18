package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class CagentQrcodepay {
    private Integer id;

    private Integer cid;

    private String type;

    private String accountcode;

    private String accountname;

    private String accountimg;

    private String rmk;

    private String status;

    private Date updatetime;

    private Long uid;

    private Double dayquota;

    private Double minquota;

    private Double maxquota;
    
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode == null ? null : accountcode.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getAccountimg() {
        return accountimg;
    }

    public void setAccountimg(String accountimg) {
        this.accountimg = accountimg == null ? null : accountimg.trim();
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Double getDayquota() {
        return dayquota;
    }

    public void setDayquota(Double dayquota) {
        this.dayquota = dayquota;
    }

    public Double getMinquota() {
        return minquota;
    }

    public void setMinquota(Double minquota) {
        this.minquota = minquota;
    }

    public Double getMaxquota() {
        return maxquota;
    }

    public void setMaxquota(Double maxquota) {
        this.maxquota = maxquota;
    }
}