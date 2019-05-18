package com.cn.tianxia.admin.project.txdata;

public class CommissionDetails {
    private Integer id;

    private Integer proxyUserId;

    private String cagent;

    private Integer noteNum;

    private Float betAmount;

    private Float validBetAmount;

    private Float netAmount;

    private Integer months;

    private Float deposit;

    private Float withdraw;

    private Float commission;

    private String commissionSettlement;

    private Float tsAmount;

    private Float tyAmount;

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

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
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

    public String getCommissionSettlement() {
        return commissionSettlement;
    }

    public void setCommissionSettlement(String commissionSettlement) {
        this.commissionSettlement = commissionSettlement == null ? null : commissionSettlement.trim();
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
}