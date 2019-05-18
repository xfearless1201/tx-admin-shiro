package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName HBGameRecord
 * @Description TODO(HABA电子实体类)
 * @author Hardy
 * @Date 2019年5月17日 下午6:48:56
 * @version 1.0.0
 */
public class HBGameRecord extends ResultCommonField{
    private static final long serialVersionUID = -2099207874050046521L;

    private Integer id;

    private String playerid;

    private String brandid;

    private String username;

    private String brandgameid;

    private String gamekeyname;

    private Integer gametypeid;

    private Date dtstarted;

    private Date dtcompleted;

    private Integer friendlygameinstanceid;

    private String gameinstanceid;

    private Float stake;

    private Float payout;

    private Float jackpotwin;

    private String jackpotcontribution;

    private String currencycode;

    private String channeltypeid;

    private String cagent;

    private Date pullTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid == null ? null : playerid.trim();
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid == null ? null : brandid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getBrandgameid() {
        return brandgameid;
    }

    public void setBrandgameid(String brandgameid) {
        this.brandgameid = brandgameid == null ? null : brandgameid.trim();
    }

    public String getGamekeyname() {
        return gamekeyname;
    }

    public void setGamekeyname(String gamekeyname) {
        this.gamekeyname = gamekeyname == null ? null : gamekeyname.trim();
    }

    public Integer getGametypeid() {
        return gametypeid;
    }

    public void setGametypeid(Integer gametypeid) {
        this.gametypeid = gametypeid;
    }

    public Date getDtstarted() {
        return dtstarted;
    }

    public void setDtstarted(Date dtstarted) {
        this.dtstarted = dtstarted;
    }

    public Date getDtcompleted() {
        return dtcompleted;
    }

    public void setDtcompleted(Date dtcompleted) {
        this.dtcompleted = dtcompleted;
    }

    public Integer getFriendlygameinstanceid() {
        return friendlygameinstanceid;
    }

    public void setFriendlygameinstanceid(Integer friendlygameinstanceid) {
        this.friendlygameinstanceid = friendlygameinstanceid;
    }

    public String getGameinstanceid() {
        return gameinstanceid;
    }

    public void setGameinstanceid(String gameinstanceid) {
        this.gameinstanceid = gameinstanceid == null ? null : gameinstanceid.trim();
    }

    public Float getStake() {
        return stake;
    }

    public void setStake(Float stake) {
        this.stake = stake;
    }

    public Float getPayout() {
        return payout;
    }

    public void setPayout(Float payout) {
        this.payout = payout;
    }

    public Float getJackpotwin() {
        return jackpotwin;
    }

    public void setJackpotwin(Float jackpotwin) {
        this.jackpotwin = jackpotwin;
    }

    public String getJackpotcontribution() {
        return jackpotcontribution;
    }

    public void setJackpotcontribution(String jackpotcontribution) {
        this.jackpotcontribution = jackpotcontribution == null ? null : jackpotcontribution.trim();
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode == null ? null : currencycode.trim();
    }

    public String getChanneltypeid() {
        return channeltypeid;
    }

    public void setChanneltypeid(String channeltypeid) {
        this.channeltypeid = channeltypeid == null ? null : channeltypeid.trim();
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