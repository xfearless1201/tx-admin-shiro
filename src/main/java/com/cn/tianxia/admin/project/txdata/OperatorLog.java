package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class OperatorLog {
    private Integer id;

    private String cagent;

    private Date addTime;

    private String ip;

    private Integer operatorId;

    private String object;

    private String oldParams;

    private String newParams;

    private String modelName;

    private String functionName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object == null ? null : object.trim();
    }

    public String getOldParams() {
        return oldParams;
    }

    public void setOldParams(String oldParams) {
        this.oldParams = oldParams == null ? null : oldParams.trim();
    }

    public String getNewParams() {
        return newParams;
    }

    public void setNewParams(String newParams) {
        this.newParams = newParams == null ? null : newParams.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }
}