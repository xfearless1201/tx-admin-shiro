package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName BbinRecord
 * @Description TODO(Bbin视讯实体类)
 * @author Hardy
 * @Date 2019年5月12日 下午8:29:43
 * @version 1.0.0
 */
public class BbinRecord extends ResultCommonField{
    
    private static final long serialVersionUID = -6685535067234369547L;

    private Integer id;

    private String username;

    private String wagersid;

    private Date wagersdate;

    private String serialid;

    private String roundno;

    private String gametype;

    private String wagerdetail;

    private String gamecode;

    private String result;

    private String resulttype;

    private String card;

    private Float betamount;

    private Float payoff;

    private String currency;

    private Float exchangerate;

    private Float commissionable;

    private String origin;

    private String cagent;

    private Date pullTime;

    private Boolean type;

    private String wagervalue;

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

    public String getWagersid() {
        return wagersid;
    }

    public void setWagersid(String wagersid) {
        this.wagersid = wagersid == null ? null : wagersid.trim();
    }

    public Date getWagersdate() {
        return wagersdate;
    }

    public void setWagersdate(Date wagersdate) {
        this.wagersdate = wagersdate;
    }

    public String getSerialid() {
        return serialid;
    }

    public void setSerialid(String serialid) {
        this.serialid = serialid == null ? null : serialid.trim();
    }

    public String getRoundno() {
        return roundno;
    }

    public void setRoundno(String roundno) {
        this.roundno = roundno == null ? null : roundno.trim();
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public String getWagerdetail() {
        return wagerdetail;
    }

    public void setWagerdetail(String wagerdetail) {
        this.wagerdetail = wagerdetail == null ? null : wagerdetail.trim();
    }

    public String getGamecode() {
        return gamecode;
    }

    public void setGamecode(String gamecode) {
        this.gamecode = gamecode == null ? null : gamecode.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getResulttype() {
        return resulttype;
    }

    public void setResulttype(String resulttype) {
        this.resulttype = resulttype == null ? null : resulttype.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public Float getBetamount() {
        return betamount;
    }

    public void setBetamount(Float betamount) {
        this.betamount = betamount;
    }

    public Float getPayoff() {
        return payoff;
    }

    public void setPayoff(Float payoff) {
        this.payoff = payoff;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Float getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Float exchangerate) {
        this.exchangerate = exchangerate;
    }

    public Float getCommissionable() {
        return commissionable;
    }

    public void setCommissionable(Float commissionable) {
        this.commissionable = commissionable;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getWagervalue() {
        return wagervalue;
    }

    public void setWagervalue(String wagervalue) {
        this.wagervalue = wagervalue == null ? null : wagervalue.trim();
    }
}