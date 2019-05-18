package com.cn.tianxia.admin.project.txdata;

public class GuagualeActivity {
    private Long id;

    private Long activityId;

    private String title;

    private String description;

    private Long minquota;

    private Long maxquota;

    private Long userMoney;

    private Byte type;

    private Long activityMoney;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getMinquota() {
        return minquota;
    }

    public void setMinquota(Long minquota) {
        this.minquota = minquota;
    }

    public Long getMaxquota() {
        return maxquota;
    }

    public void setMaxquota(Long maxquota) {
        this.maxquota = maxquota;
    }

    public Long getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Long userMoney) {
        this.userMoney = userMoney;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getActivityMoney() {
        return activityMoney;
    }

    public void setActivityMoney(Long activityMoney) {
        this.activityMoney = activityMoney;
    }
}