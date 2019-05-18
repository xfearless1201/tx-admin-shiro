package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

/**
 * 
 * @ClassName AccountsCollect
 * @Description 资金汇总数据表实体类
 * @author Hardy
 * @Date 2019年4月22日 下午2:56:03
 * @version 1.0.0
 */
public class AccountsCollect {
    private Integer id;

    private Integer cid;

    private Float incomeAmount;

    private Float expendAmount;

    private Float managerAmount;

    private Float validbetAmount;

    private Float withholdPoundage;

    private Float commission;

    private Float depositPoundage;

    private Float largess;

    private Float handDeposit;

    private Float handWithhold;

    private Date addTime;

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

    public Float getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Float incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Float getExpendAmount() {
        return expendAmount;
    }

    public void setExpendAmount(Float expendAmount) {
        this.expendAmount = expendAmount;
    }

    public Float getManagerAmount() {
        return managerAmount;
    }

    public void setManagerAmount(Float managerAmount) {
        this.managerAmount = managerAmount;
    }

    public Float getValidbetAmount() {
        return validbetAmount;
    }

    public void setValidbetAmount(Float validbetAmount) {
        this.validbetAmount = validbetAmount;
    }

    public Float getWithholdPoundage() {
        return withholdPoundage;
    }

    public void setWithholdPoundage(Float withholdPoundage) {
        this.withholdPoundage = withholdPoundage;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Float getDepositPoundage() {
        return depositPoundage;
    }

    public void setDepositPoundage(Float depositPoundage) {
        this.depositPoundage = depositPoundage;
    }

    public Float getLargess() {
        return largess;
    }

    public void setLargess(Float largess) {
        this.largess = largess;
    }

    public Float getHandDeposit() {
        return handDeposit;
    }

    public void setHandDeposit(Float handDeposit) {
        this.handDeposit = handDeposit;
    }

    public Float getHandWithhold() {
        return handWithhold;
    }

    public void setHandWithhold(Float handWithhold) {
        this.handWithhold = handWithhold;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}