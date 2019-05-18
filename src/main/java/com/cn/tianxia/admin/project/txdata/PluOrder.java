package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class PluOrder {
    private Integer id;

    private Integer uid;

    private Integer cid;

    private Integer pluId;

    private Integer pluNumber;

    private Date orderTime;

    private String deliverAddress;

    private String deliverPhone;

    private String deliverName;

    private Byte deliverStatus;

    private Integer auditId;

    private Date auditTime;

    private String rmk;

    private Byte orderState;

    private String deliverRmk;

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPluId() {
        return pluId;
    }

    public void setPluId(Integer pluId) {
        this.pluId = pluId;
    }

    public Integer getPluNumber() {
        return pluNumber;
    }

    public void setPluNumber(Integer pluNumber) {
        this.pluNumber = pluNumber;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress == null ? null : deliverAddress.trim();
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }

    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone == null ? null : deliverPhone.trim();
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName == null ? null : deliverName.trim();
    }

    public Byte getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(Byte deliverStatus) {
        this.deliverStatus = deliverStatus;
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

    public Byte getOrderState() {
        return orderState;
    }

    public void setOrderState(Byte orderState) {
        this.orderState = orderState;
    }

    public String getDeliverRmk() {
        return deliverRmk;
    }

    public void setDeliverRmk(String deliverRmk) {
        this.deliverRmk = deliverRmk == null ? null : deliverRmk.trim();
    }
}