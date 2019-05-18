package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName CQJGameRecord
 * @Description TODO(CQJ电子实体类)
 * @author Hardy
 * @Date 2019年5月18日 下午5:25:41
 * @version 1.0.0
 */
public class CQJGameRecord extends ResultCommonField{
    private static final long serialVersionUID = -998806416172430804L;

    private Integer id;

    private String cagent;

    private String gamecode;

    private String gametype;

    private String gameplat;

    private String account;

    private String round;

    private Float bet;

    private Float win;

    private Float jackpot;

    private String jackpottype;

    private Float winpc;

    private Float balance;

    private String status;

    private Date bettime;

    private Date endroundtime;

    private Date createtime;

    private Float rake;

    private String gamerole;

    private String bankertype;

    private String jackpotcontribution;

    private String detail;

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

    public String getGamecode() {
        return gamecode;
    }

    public void setGamecode(String gamecode) {
        this.gamecode = gamecode == null ? null : gamecode.trim();
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public String getGameplat() {
        return gameplat;
    }

    public void setGameplat(String gameplat) {
        this.gameplat = gameplat == null ? null : gameplat.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round == null ? null : round.trim();
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

    public Float getJackpot() {
        return jackpot;
    }

    public void setJackpot(Float jackpot) {
        this.jackpot = jackpot;
    }

    public String getJackpottype() {
        return jackpottype;
    }

    public void setJackpottype(String jackpottype) {
        this.jackpottype = jackpottype == null ? null : jackpottype.trim();
    }

    public Float getWinpc() {
        return winpc;
    }

    public void setWinpc(Float winpc) {
        this.winpc = winpc;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public Date getEndroundtime() {
        return endroundtime;
    }

    public void setEndroundtime(Date endroundtime) {
        this.endroundtime = endroundtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Float getRake() {
        return rake;
    }

    public void setRake(Float rake) {
        this.rake = rake;
    }

    public String getGamerole() {
        return gamerole;
    }

    public void setGamerole(String gamerole) {
        this.gamerole = gamerole == null ? null : gamerole.trim();
    }

    public String getBankertype() {
        return bankertype;
    }

    public void setBankertype(String bankertype) {
        this.bankertype = bankertype == null ? null : bankertype.trim();
    }

    public String getJackpotcontribution() {
        return jackpotcontribution;
    }

    public void setJackpotcontribution(String jackpotcontribution) {
        this.jackpotcontribution = jackpotcontribution == null ? null : jackpotcontribution.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}