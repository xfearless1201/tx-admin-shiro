package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

import org.springframework.stereotype.Service;
/**
 * 
 * @ClassName PTGameRecord
 * @Description TODO(PT电子实体类)
 * @author Hardy
 * @Date 2019年5月17日 下午9:08:03
 * @version 1.0.0
 */
@Service
public class PTGameRecord extends ResultCommonField{
    private static final long serialVersionUID = -7687209822428245773L;

    private Integer id;

    private String playername;

    private Integer windowcode;

    private Integer gameid;

    private String gamecode;

    private String gametype;

    private String gamename;

    private Integer sessionid;

    private Float bet;

    private Float win;

    private String progressivebet;

    private String progressivewin;

    private Float balance;

    private String currentbet;

    private Date gamedate;

    private String livenetwork;

    private Integer rnum;

    private String cagent;

    private Date pullTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername == null ? null : playername.trim();
    }

    public Integer getWindowcode() {
        return windowcode;
    }

    public void setWindowcode(Integer windowcode) {
        this.windowcode = windowcode;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
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

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public Integer getSessionid() {
        return sessionid;
    }

    public void setSessionid(Integer sessionid) {
        this.sessionid = sessionid;
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

    public String getProgressivebet() {
        return progressivebet;
    }

    public void setProgressivebet(String progressivebet) {
        this.progressivebet = progressivebet == null ? null : progressivebet.trim();
    }

    public String getProgressivewin() {
        return progressivewin;
    }

    public void setProgressivewin(String progressivewin) {
        this.progressivewin = progressivewin == null ? null : progressivewin.trim();
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getCurrentbet() {
        return currentbet;
    }

    public void setCurrentbet(String currentbet) {
        this.currentbet = currentbet == null ? null : currentbet.trim();
    }

    public Date getGamedate() {
        return gamedate;
    }

    public void setGamedate(Date gamedate) {
        this.gamedate = gamedate;
    }

    public String getLivenetwork() {
        return livenetwork;
    }

    public void setLivenetwork(String livenetwork) {
        this.livenetwork = livenetwork == null ? null : livenetwork.trim();
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public Date getPullTime() {
        return pullTime;
    }

    public void setPullTime(Date pullTime) {
        this.pullTime = pullTime;
    }
}