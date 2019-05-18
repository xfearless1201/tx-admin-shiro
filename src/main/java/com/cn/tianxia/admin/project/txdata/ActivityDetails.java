package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

/**
 * 
 * @ClassName ActivityDetails
 * @Description 活动表
 * @author Hardy
 * @Date 2019年4月22日 下午2:59:05
 * @version 1.0.0
 */
public class ActivityDetails {
    private Integer id;

    private Integer cid;

    private String activityName;

    private Integer activityTypes;

    private Integer activityStatus;

    private Integer userType;

    private Integer requiredIntegral;

    private Integer participateTheway;

    private Integer participateFrequency;

    private Integer frequencyMax;

    private Date startTime;

    private Date endTime;

    private String rmk;

    private Date addTime;

    private String participateCycle;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Integer getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(Integer activityTypes) {
        this.activityTypes = activityTypes;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getRequiredIntegral() {
        return requiredIntegral;
    }

    public void setRequiredIntegral(Integer requiredIntegral) {
        this.requiredIntegral = requiredIntegral;
    }

    public Integer getParticipateTheway() {
        return participateTheway;
    }

    public void setParticipateTheway(Integer participateTheway) {
        this.participateTheway = participateTheway;
    }

    public Integer getParticipateFrequency() {
        return participateFrequency;
    }

    public void setParticipateFrequency(Integer participateFrequency) {
        this.participateFrequency = participateFrequency;
    }

    public Integer getFrequencyMax() {
        return frequencyMax;
    }

    public void setFrequencyMax(Integer frequencyMax) {
        this.frequencyMax = frequencyMax;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getParticipateCycle() {
        return participateCycle;
    }

    public void setParticipateCycle(String participateCycle) {
        this.participateCycle = participateCycle == null ? null : participateCycle.trim();
    }
}