package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class Fundmanage {
    private Integer id;

    private Integer uid;

    private Float yhAmount;

    private Float cjAmount;

    private Float dmlAmount;

    private String tType;

    private String type;

    private Byte orderStatue;

    private Integer auditId;

    private Date auditTime;

    private String rmk;

    private Date addTime;

    private String number;

    private Float amount;

    private Integer operatorId;

    private Float integralAmount;

    private Byte isClearDml;

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

    public Float getYhAmount() {
        return yhAmount;
    }

    public void setYhAmount(Float yhAmount) {
        this.yhAmount = yhAmount;
    }

    public Float getCjAmount() {
        return cjAmount;
    }

    public void setCjAmount(Float cjAmount) {
        this.cjAmount = cjAmount;
    }

    public Float getDmlAmount() {
        return dmlAmount;
    }

    public void setDmlAmount(Float dmlAmount) {
        this.dmlAmount = dmlAmount;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType == null ? null : tType.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Byte getOrderStatue() {
        return orderStatue;
    }

    public void setOrderStatue(Byte orderStatue) {
        this.orderStatue = orderStatue;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Float getIntegralAmount() {
        return integralAmount;
    }

    public void setIntegralAmount(Float integralAmount) {
        this.integralAmount = integralAmount;
    }

    public Byte getIsClearDml() {
        return isClearDml;
    }

    public void setIsClearDml(Byte isClearDml) {
        this.isClearDml = isClearDml;
    }
}