package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName DsRecord
 * @Description TODO(DS视讯实体类)
 * @author Hardy
 * @Date 2019年5月14日 下午12:24:30
 * @version 1.0.0
 */
public class DsRecord extends ResultCommonField{

    private static final long serialVersionUID = 3538907838658959389L;

    private Integer id;

    private Integer sequenceno;

    private String gametype;

    private String username;

    private String currency;

    private String tablename;

    private String issueno;

    private String bankerresult;

    private String resultlist;

    private String pokerlist;

    private Float stakeamount;

    private Float validstake;

    private String comm;

    private Float winloss;

    private Float balanceafter;

    private Date endtime;

    private String ip;

    private String resultimgname;

    private String tips;

    private Integer tableinfoid;

    private Integer shoeinfoid;

    private Integer gameinfoid;

    private Date adjustmenttime;

    private Integer type;

    private String recordidlist;

    private String cagent;

    private Date pullTime;

    private Integer pullDataId;

    private String betType;

    private String wagervalue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSequenceno() {
        return sequenceno;
    }

    public void setSequenceno(Integer sequenceno) {
        this.sequenceno = sequenceno;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getIssueno() {
        return issueno;
    }

    public void setIssueno(String issueno) {
        this.issueno = issueno == null ? null : issueno.trim();
    }

    public String getBankerresult() {
        return bankerresult;
    }

    public void setBankerresult(String bankerresult) {
        this.bankerresult = bankerresult == null ? null : bankerresult.trim();
    }

    public String getResultlist() {
        return resultlist;
    }

    public void setResultlist(String resultlist) {
        this.resultlist = resultlist == null ? null : resultlist.trim();
    }

    public String getPokerlist() {
        return pokerlist;
    }

    public void setPokerlist(String pokerlist) {
        this.pokerlist = pokerlist == null ? null : pokerlist.trim();
    }

    public Float getStakeamount() {
        return stakeamount;
    }

    public void setStakeamount(Float stakeamount) {
        this.stakeamount = stakeamount;
    }

    public Float getValidstake() {
        return validstake;
    }

    public void setValidstake(Float validstake) {
        this.validstake = validstake;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm == null ? null : comm.trim();
    }

    public Float getWinloss() {
        return winloss;
    }

    public void setWinloss(Float winloss) {
        this.winloss = winloss;
    }

    public Float getBalanceafter() {
        return balanceafter;
    }

    public void setBalanceafter(Float balanceafter) {
        this.balanceafter = balanceafter;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getResultimgname() {
        return resultimgname;
    }

    public void setResultimgname(String resultimgname) {
        this.resultimgname = resultimgname == null ? null : resultimgname.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public Integer getTableinfoid() {
        return tableinfoid;
    }

    public void setTableinfoid(Integer tableinfoid) {
        this.tableinfoid = tableinfoid;
    }

    public Integer getShoeinfoid() {
        return shoeinfoid;
    }

    public void setShoeinfoid(Integer shoeinfoid) {
        this.shoeinfoid = shoeinfoid;
    }

    public Integer getGameinfoid() {
        return gameinfoid;
    }

    public void setGameinfoid(Integer gameinfoid) {
        this.gameinfoid = gameinfoid;
    }

    public Date getAdjustmenttime() {
        return adjustmenttime;
    }

    public void setAdjustmenttime(Date adjustmenttime) {
        this.adjustmenttime = adjustmenttime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRecordidlist() {
        return recordidlist;
    }

    public void setRecordidlist(String recordidlist) {
        this.recordidlist = recordidlist == null ? null : recordidlist.trim();
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

    public Integer getPullDataId() {
        return pullDataId;
    }

    public void setPullDataId(Integer pullDataId) {
        this.pullDataId = pullDataId;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType == null ? null : betType.trim();
    }

    public String getWagervalue() {
        return wagervalue;
    }

    public void setWagervalue(String wagervalue) {
        this.wagervalue = wagervalue == null ? null : wagervalue.trim();
    }
}