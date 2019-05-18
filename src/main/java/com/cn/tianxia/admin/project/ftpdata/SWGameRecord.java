package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName SWGameRecord
 * @Description TODO(SW电子实体类)
 * @author Hardy
 * @Date 2019年5月18日 下午12:22:45
 * @version 1.0.0
 */
public class SWGameRecord extends ResultCommonField{
    private static final long serialVersionUID = 8315812095519667788L;

    private Long id;

    private String roundid;

    private String brandid;

    private String playercode;

    private String gamecode;

    private String currency;

    private Float bet;

    private Float win;

    private Float revenue;

    private Date firstts;

    private Date ts;

    private String finished;

    private String istest;

    private Float balancebefore;

    private Float balanceafter;

    private Integer totalevents;

    private Date insertedat;

    private String device;

    private String cagent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoundid() {
        return roundid;
    }

    public void setRoundid(String roundid) {
        this.roundid = roundid == null ? null : roundid.trim();
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid == null ? null : brandid.trim();
    }

    public String getPlayercode() {
        return playercode;
    }

    public void setPlayercode(String playercode) {
        this.playercode = playercode == null ? null : playercode.trim();
    }

    public String getGamecode() {
        return gamecode;
    }

    public void setGamecode(String gamecode) {
        this.gamecode = gamecode == null ? null : gamecode.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Float getBet() {
        return bet;
    }

    public void setBet(Float bet) {
        this.bet = bet;
    }

    public Float getWin() {
        return win;
    }

    public void setWin(Float win) {
        this.win = win;
    }

    public Float getRevenue() {
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public Date getFirstts() {
        return firstts;
    }

    public void setFirstts(Date firstts) {
        this.firstts = firstts;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished == null ? null : finished.trim();
    }

    public String getIstest() {
        return istest;
    }

    public void setIstest(String istest) {
        this.istest = istest == null ? null : istest.trim();
    }

    public Float getBalancebefore() {
        return balancebefore;
    }

    public void setBalancebefore(Float balancebefore) {
        this.balancebefore = balancebefore;
    }

    public Float getBalanceafter() {
        return balanceafter;
    }

    public void setBalanceafter(Float balanceafter) {
        this.balanceafter = balanceafter;
    }

    public Integer getTotalevents() {
        return totalevents;
    }

    public void setTotalevents(Integer totalevents) {
        this.totalevents = totalevents;
    }

    public Date getInsertedat() {
        return insertedat;
    }

    public void setInsertedat(Date insertedat) {
        this.insertedat = insertedat;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }
}