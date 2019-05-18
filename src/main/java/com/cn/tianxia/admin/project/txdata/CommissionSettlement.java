package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class CommissionSettlement {
    private Integer id;

    private Integer proxyUserId;

    private String cagent;

    private Integer noteNum;

    private Float betAmount;

    private Float validBetAmount;

    private Float netAmount;

    private Integer startMonths;

    private Integer endMonths;

    private Float managerFee;

    private Float paymentFee;

    private Float withdrawFee;

    private Float deposit;

    private Float withdraw;

    private Float commission;

    private Float tsAmount;

    private Float tyAmount;

    private Integer billStatus;

    private Date createTime;

    private Date updateTime;

    private String auditor;

    private String rmk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProxyUserId() {
        return proxyUserId;
    }

    public void setProxyUserId(Integer proxyUserId) {
        this.proxyUserId = proxyUserId;
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public Integer getNoteNum() {
        return noteNum;
    }

    public void setNoteNum(Integer noteNum) {
        this.noteNum = noteNum;
    }

    public Float getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Float betAmount) {
        this.betAmount = betAmount;
    }

    public Float getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(Float validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public Float getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Float netAmount) {
        this.netAmount = netAmount;
    }

    public Integer getStartMonths() {
        return startMonths;
    }

    public void setStartMonths(Integer startMonths) {
        this.startMonths = startMonths;
    }

    public Integer getEndMonths() {
        return endMonths;
    }

    public void setEndMonths(Integer endMonths) {
        this.endMonths = endMonths;
    }

    public Float getManagerFee() {
        return managerFee;
    }

    public void setManagerFee(Float managerFee) {
        this.managerFee = managerFee;
    }

    public Float getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(Float paymentFee) {
        this.paymentFee = paymentFee;
    }

    public Float getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(Float withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    public Float getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Float withdraw) {
        this.withdraw = withdraw;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Float getTsAmount() {
        return tsAmount;
    }

    public void setTsAmount(Float tsAmount) {
        this.tsAmount = tsAmount;
    }

    public Float getTyAmount() {
        return tyAmount;
    }

    public void setTyAmount(Float tyAmount) {
        this.tyAmount = tyAmount;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }
}