package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName PSGameRecord
 * @Description TODO(PS电子实体类)
 * @author Hardy
 * @Date 2019年5月18日 上午11:10:49
 * @version 1.0.0
 */
public class PSGameRecord extends ResultCommonField{
    private static final long serialVersionUID = 7047151179918967718L;

    private Integer id;

    private String username;

    private Long sn;

    private String gid;

    private String sid;

    private Date tm;

    private Double bet;

    private Double dm;

    private Double win;

    private Double bn;

    private Double gb;

    private Double jp;

    private String ex;

    private String cagent;

    private String bd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public Date getTm() {
        return tm;
    }

    public void setTm(Date tm) {
        this.tm = tm;
    }

    public Double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public Double getDm() {
        return dm;
    }

    public void setDm(Double dm) {
        this.dm = dm;
    }

    public Double getWin() {
        return win;
    }

    public void setWin(Double win) {
        this.win = win;
    }

    public Double getBn() {
        return bn;
    }

    public void setBn(Double bn) {
        this.bn = bn;
    }

    public Double getGb() {
        return gb;
    }

    public void setGb(Double gb) {
        this.gb = gb;
    }

    public Double getJp() {
        return jp;
    }

    public void setJp(Double jp) {
        this.jp = jp;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex == null ? null : ex.trim();
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd == null ? null : bd.trim();
    }
}