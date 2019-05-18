package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class PluInventory {
    private Integer id;

    private Integer pluid;

    private Integer cid;

    private Integer num;

    private Integer freezeNum;

    private Date uptime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPluid() {
        return pluid;
    }

    public void setPluid(Integer pluid) {
        this.pluid = pluid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getFreezeNum() {
        return freezeNum;
    }

    public void setFreezeNum(Integer freezeNum) {
        this.freezeNum = freezeNum;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}