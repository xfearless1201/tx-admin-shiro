package com.cn.tianxia.admin.project.txdata;

public class SigninTemplate {
    private Integer id;

    private String templateName;

    private Integer activityId;

    private Integer templateDay;

    private String templateReward;

    private Integer rewardType;

    private Integer status;

    private Integer prizeType;

    private Integer expendIntegral;

    private Integer isDelete;

    private Integer activityTypes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getTemplateDay() {
        return templateDay;
    }

    public void setTemplateDay(Integer templateDay) {
        this.templateDay = templateDay;
    }

    public String getTemplateReward() {
        return templateReward;
    }

    public void setTemplateReward(String templateReward) {
        this.templateReward = templateReward == null ? null : templateReward.trim();
    }

    public Integer getRewardType() {
        return rewardType;
    }

    public void setRewardType(Integer rewardType) {
        this.rewardType = rewardType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }

    public Integer getExpendIntegral() {
        return expendIntegral;
    }

    public void setExpendIntegral(Integer expendIntegral) {
        this.expendIntegral = expendIntegral;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(Integer activityTypes) {
        this.activityTypes = activityTypes;
    }
}