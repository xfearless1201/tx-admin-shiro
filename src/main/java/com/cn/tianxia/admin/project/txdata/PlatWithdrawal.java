package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class PlatWithdrawal {
    private Integer id;

    private Integer cid;

    private Float companyPayProp;

    private Float giftBonusProp;

    private Integer giftBonusLimit;

    private Float dama;

    private Integer freeWithdrawTime;

    private Float withdrawFee;

    private Integer withdrawManageFee;

    private Float compulsoryWithdrawalFee;

    private Date updatetime;

    private Long uid;

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

    public Float getCompanyPayProp() {
        return companyPayProp;
    }

    public void setCompanyPayProp(Float companyPayProp) {
        this.companyPayProp = companyPayProp;
    }

    public Float getGiftBonusProp() {
        return giftBonusProp;
    }

    public void setGiftBonusProp(Float giftBonusProp) {
        this.giftBonusProp = giftBonusProp;
    }

    public Integer getGiftBonusLimit() {
        return giftBonusLimit;
    }

    public void setGiftBonusLimit(Integer giftBonusLimit) {
        this.giftBonusLimit = giftBonusLimit;
    }

    public Float getDama() {
        return dama;
    }

    public void setDama(Float dama) {
        this.dama = dama;
    }

    public Integer getFreeWithdrawTime() {
        return freeWithdrawTime;
    }

    public void setFreeWithdrawTime(Integer freeWithdrawTime) {
        this.freeWithdrawTime = freeWithdrawTime;
    }

    public Float getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(Float withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public Integer getWithdrawManageFee() {
        return withdrawManageFee;
    }

    public void setWithdrawManageFee(Integer withdrawManageFee) {
        this.withdrawManageFee = withdrawManageFee;
    }

    public Float getCompulsoryWithdrawalFee() {
        return compulsoryWithdrawalFee;
    }

    public void setCompulsoryWithdrawalFee(Float compulsoryWithdrawalFee) {
        this.compulsoryWithdrawalFee = compulsoryWithdrawalFee;
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
}