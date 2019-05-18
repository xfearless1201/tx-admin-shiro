package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

/**
 * 
 * @ClassName AccountDaySum
 * @Description 帐目日汇总表实体类
 * @author Hardy
 * @Date 2019年4月22日 下午2:54:33
 * @version 1.0.0
 */
public class AccountDaySum {
    private Long id;

    private String cagent;

    private Double onlinPayment;

    private Double returnWater;

    private Double adminFee;

    private Double poundage;

    private Double colorGold;

    private Double discount;

    private Double manualAddition;

    private Double manualDeductions;

    private Double returnWaterToZero;

    private Long depositNum;

    private Double depositSum;

    private Long firstDeposit;

    private Double firstSum;

    private Long withdrawNum;

    private Double withdrawSum;

    private Double usedvaue;

    private Double remainAmount;

    private Double profit;

    private Long registration;

    private Date createDate;

    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public Double getOnlinPayment() {
        return onlinPayment;
    }

    public void setOnlinPayment(Double onlinPayment) {
        this.onlinPayment = onlinPayment;
    }

    public Double getReturnWater() {
        return returnWater;
    }

    public void setReturnWater(Double returnWater) {
        this.returnWater = returnWater;
    }

    public Double getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(Double adminFee) {
        this.adminFee = adminFee;
    }

    public Double getPoundage() {
        return poundage;
    }

    public void setPoundage(Double poundage) {
        this.poundage = poundage;
    }

    public Double getColorGold() {
        return colorGold;
    }

    public void setColorGold(Double colorGold) {
        this.colorGold = colorGold;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getManualAddition() {
        return manualAddition;
    }

    public void setManualAddition(Double manualAddition) {
        this.manualAddition = manualAddition;
    }

    public Double getManualDeductions() {
        return manualDeductions;
    }

    public void setManualDeductions(Double manualDeductions) {
        this.manualDeductions = manualDeductions;
    }

    public Double getReturnWaterToZero() {
        return returnWaterToZero;
    }

    public void setReturnWaterToZero(Double returnWaterToZero) {
        this.returnWaterToZero = returnWaterToZero;
    }

    public Long getDepositNum() {
        return depositNum;
    }

    public void setDepositNum(Long depositNum) {
        this.depositNum = depositNum;
    }

    public Double getDepositSum() {
        return depositSum;
    }

    public void setDepositSum(Double depositSum) {
        this.depositSum = depositSum;
    }

    public Long getFirstDeposit() {
        return firstDeposit;
    }

    public void setFirstDeposit(Long firstDeposit) {
        this.firstDeposit = firstDeposit;
    }

    public Double getFirstSum() {
        return firstSum;
    }

    public void setFirstSum(Double firstSum) {
        this.firstSum = firstSum;
    }

    public Long getWithdrawNum() {
        return withdrawNum;
    }

    public void setWithdrawNum(Long withdrawNum) {
        this.withdrawNum = withdrawNum;
    }

    public Double getWithdrawSum() {
        return withdrawSum;
    }

    public void setWithdrawSum(Double withdrawSum) {
        this.withdrawSum = withdrawSum;
    }

    public Double getUsedvaue() {
        return usedvaue;
    }

    public void setUsedvaue(Double usedvaue) {
        this.usedvaue = usedvaue;
    }

    public Double getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Double remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Long getRegistration() {
        return registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}