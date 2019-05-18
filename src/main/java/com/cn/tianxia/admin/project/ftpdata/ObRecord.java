package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName ObRecord
 * @Description TODO(欧博视讯实体类)
 * @author Hardy
 * @Date 2019年5月14日 下午3:31:38
 * @version 1.0.0
 */
public class ObRecord extends ResultCommonField{
    
    private static final long serialVersionUID = -837907579116775355L;

    private Integer id;

    private String client;

    private String betnum;

    private String gameroundid;

    private String gametype;

    private Date bettime;

    private Float betamount;

    private Float validamount;

    private Float winorloss;

    private Boolean state;

    private String currency;

    private Float exchangerrate;

    private Integer bettype;

    private String gameresult;

    private Date gameroundendtime;

    private Date gameroundstarttime;

    private String tablename;

    private Integer commission;

    private String cagent;

    private Date pullTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

    public String getBetnum() {
        return betnum;
    }

    public void setBetnum(String betnum) {
        this.betnum = betnum == null ? null : betnum.trim();
    }

    public String getGameroundid() {
        return gameroundid;
    }

    public void setGameroundid(String gameroundid) {
        this.gameroundid = gameroundid == null ? null : gameroundid.trim();
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public Float getBetamount() {
        return betamount;
    }

    public void setBetamount(Float betamount) {
        this.betamount = betamount;
    }

    public Float getValidamount() {
        return validamount;
    }

    public void setValidamount(Float validamount) {
        this.validamount = validamount;
    }

    public Float getWinorloss() {
        return winorloss;
    }

    public void setWinorloss(Float winorloss) {
        this.winorloss = winorloss;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Float getExchangerrate() {
        return exchangerrate;
    }

    public void setExchangerrate(Float exchangerrate) {
        this.exchangerrate = exchangerrate;
    }

    public Integer getBettype() {
        return bettype;
    }

    public void setBettype(Integer bettype) {
        this.bettype = bettype;
    }

    public String getGameresult() {
        return gameresult;
    }

    public void setGameresult(String gameresult) {
        this.gameresult = gameresult == null ? null : gameresult.trim();
    }

    public Date getGameroundendtime() {
        return gameroundendtime;
    }

    public void setGameroundendtime(Date gameroundendtime) {
        this.gameroundendtime = gameroundendtime;
    }

    public Date getGameroundstarttime() {
        return gameroundstarttime;
    }

    public void setGameroundstarttime(Date gameroundstarttime) {
        this.gameroundstarttime = gameroundstarttime;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
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