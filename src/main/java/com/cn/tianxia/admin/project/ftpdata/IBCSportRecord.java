package com.cn.tianxia.admin.project.ftpdata;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @ClassName IBCSportRecord
 * @Description TODO(IBC体育实体类)
 * @author Hardy
 * @Date 2019年5月18日 下午6:35:01
 * @version 1.0.0
 */
public class IBCSportRecord extends ResultCommonField{
    private static final long serialVersionUID = -5576618397081776591L;

    private Long id;

    private Long transid;

    private String playername;

    private Date transactiontime;

    private Long matchid;

    private Integer leagueid;

    private String leaguename;

    private String sporttype;

    private Long awayid;

    private String awayidname;

    private Long homeid;

    private String homeidname;

    private Date matchdatetime;

    private Integer bettype;

    private String parlayrefno;

    private String betteam;

    private BigDecimal hdp;

    private BigDecimal awayhdp;

    private BigDecimal homehdp;

    private BigDecimal odds;

    private BigDecimal awayscore;

    private BigDecimal homescore;

    private String islive;

    private String islucky;

    private String parlayType;

    private String comboType;

    private String ticketstatus;

    private Integer stake;

    private BigDecimal winloseamount;

    private Date winlostdatetime;

    private String lastballno;

    private String cagent;

    private String currency;

    private Long versionkey;

    private String betTag;

    private BigDecimal afteramount;

    private Integer oddstype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransid() {
        return transid;
    }

    public void setTransid(Long transid) {
        this.transid = transid;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername == null ? null : playername.trim();
    }

    public Date getTransactiontime() {
        return transactiontime;
    }

    public void setTransactiontime(Date transactiontime) {
        this.transactiontime = transactiontime;
    }

    public Long getMatchid() {
        return matchid;
    }

    public void setMatchid(Long matchid) {
        this.matchid = matchid;
    }

    public Integer getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(Integer leagueid) {
        this.leagueid = leagueid;
    }

    public String getLeaguename() {
        return leaguename;
    }

    public void setLeaguename(String leaguename) {
        this.leaguename = leaguename == null ? null : leaguename.trim();
    }

    public String getSporttype() {
        return sporttype;
    }

    public void setSporttype(String sporttype) {
        this.sporttype = sporttype == null ? null : sporttype.trim();
    }

    public Long getAwayid() {
        return awayid;
    }

    public void setAwayid(Long awayid) {
        this.awayid = awayid;
    }

    public String getAwayidname() {
        return awayidname;
    }

    public void setAwayidname(String awayidname) {
        this.awayidname = awayidname == null ? null : awayidname.trim();
    }

    public Long getHomeid() {
        return homeid;
    }

    public void setHomeid(Long homeid) {
        this.homeid = homeid;
    }

    public String getHomeidname() {
        return homeidname;
    }

    public void setHomeidname(String homeidname) {
        this.homeidname = homeidname == null ? null : homeidname.trim();
    }

    public Date getMatchdatetime() {
        return matchdatetime;
    }

    public void setMatchdatetime(Date matchdatetime) {
        this.matchdatetime = matchdatetime;
    }

    public Integer getBettype() {
        return bettype;
    }

    public void setBettype(Integer bettype) {
        this.bettype = bettype;
    }

    public String getParlayrefno() {
        return parlayrefno;
    }

    public void setParlayrefno(String parlayrefno) {
        this.parlayrefno = parlayrefno == null ? null : parlayrefno.trim();
    }

    public String getBetteam() {
        return betteam;
    }

    public void setBetteam(String betteam) {
        this.betteam = betteam == null ? null : betteam.trim();
    }

    public BigDecimal getHdp() {
        return hdp;
    }

    public void setHdp(BigDecimal hdp) {
        this.hdp = hdp;
    }

    public BigDecimal getAwayhdp() {
        return awayhdp;
    }

    public void setAwayhdp(BigDecimal awayhdp) {
        this.awayhdp = awayhdp;
    }

    public BigDecimal getHomehdp() {
        return homehdp;
    }

    public void setHomehdp(BigDecimal homehdp) {
        this.homehdp = homehdp;
    }

    public BigDecimal getOdds() {
        return odds;
    }

    public void setOdds(BigDecimal odds) {
        this.odds = odds;
    }

    public BigDecimal getAwayscore() {
        return awayscore;
    }

    public void setAwayscore(BigDecimal awayscore) {
        this.awayscore = awayscore;
    }

    public BigDecimal getHomescore() {
        return homescore;
    }

    public void setHomescore(BigDecimal homescore) {
        this.homescore = homescore;
    }

    public String getIslive() {
        return islive;
    }

    public void setIslive(String islive) {
        this.islive = islive == null ? null : islive.trim();
    }

    public String getIslucky() {
        return islucky;
    }

    public void setIslucky(String islucky) {
        this.islucky = islucky == null ? null : islucky.trim();
    }

    public String getParlayType() {
        return parlayType;
    }

    public void setParlayType(String parlayType) {
        this.parlayType = parlayType == null ? null : parlayType.trim();
    }

    public String getComboType() {
        return comboType;
    }

    public void setComboType(String comboType) {
        this.comboType = comboType == null ? null : comboType.trim();
    }

    public String getTicketstatus() {
        return ticketstatus;
    }

    public void setTicketstatus(String ticketstatus) {
        this.ticketstatus = ticketstatus == null ? null : ticketstatus.trim();
    }

    public Integer getStake() {
        return stake;
    }

    public void setStake(Integer stake) {
        this.stake = stake;
    }

    public BigDecimal getWinloseamount() {
        return winloseamount;
    }

    public void setWinloseamount(BigDecimal winloseamount) {
        this.winloseamount = winloseamount;
    }

    public Date getWinlostdatetime() {
        return winlostdatetime;
    }

    public void setWinlostdatetime(Date winlostdatetime) {
        this.winlostdatetime = winlostdatetime;
    }

    public String getLastballno() {
        return lastballno;
    }

    public void setLastballno(String lastballno) {
        this.lastballno = lastballno == null ? null : lastballno.trim();
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Long getVersionkey() {
        return versionkey;
    }

    public void setVersionkey(Long versionkey) {
        this.versionkey = versionkey;
    }

    public String getBetTag() {
        return betTag;
    }

    public void setBetTag(String betTag) {
        this.betTag = betTag == null ? null : betTag.trim();
    }

    public BigDecimal getAfteramount() {
        return afteramount;
    }

    public void setAfteramount(BigDecimal afteramount) {
        this.afteramount = afteramount;
    }

    public Integer getOddstype() {
        return oddstype;
    }

    public void setOddstype(Integer oddstype) {
        this.oddstype = oddstype;
    }
}