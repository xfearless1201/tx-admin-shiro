package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName OgRecord
 * @Description TODO(OG视讯实体类)
 * @author Hardy
 * @Date 2019年5月14日 下午5:39:24
 * @version 1.0.0
 */
public class OgRecord extends ResultCommonField{
    private static final long serialVersionUID = -922752607356019964L;

    private Integer id;

    private Integer productid;

    private String username;

    private Integer tableid;

    private Integer stage;

    private Integer inning;

    private String gameresult;

    private Integer gamerecordid;

    private Integer ordernumber;

    private Integer gamebettingkind;

    private Integer gamebettingcontent;

    private Integer resulttype;

    private String gameinformation;

    private Integer gamenameid;

    private Float bettingamount;

    private Float compensaterate;

    private Float winloseamount;

    private Float balance;

    private Date addtime;

    private String vendorid;

    private Float validamount;

    private Integer gamekind;

    private Integer platformid;

    private String cagent;

    private Date pullTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getInning() {
        return inning;
    }

    public void setInning(Integer inning) {
        this.inning = inning;
    }

    public String getGameresult() {
        return gameresult;
    }

    public void setGameresult(String gameresult) {
        this.gameresult = gameresult == null ? null : gameresult.trim();
    }

    public Integer getGamerecordid() {
        return gamerecordid;
    }

    public void setGamerecordid(Integer gamerecordid) {
        this.gamerecordid = gamerecordid;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Integer getGamebettingkind() {
        return gamebettingkind;
    }

    public void setGamebettingkind(Integer gamebettingkind) {
        this.gamebettingkind = gamebettingkind;
    }

    public Integer getGamebettingcontent() {
        return gamebettingcontent;
    }

    public void setGamebettingcontent(Integer gamebettingcontent) {
        this.gamebettingcontent = gamebettingcontent;
    }

    public Integer getResulttype() {
        return resulttype;
    }

    public void setResulttype(Integer resulttype) {
        this.resulttype = resulttype;
    }

    public String getGameinformation() {
        return gameinformation;
    }

    public void setGameinformation(String gameinformation) {
        this.gameinformation = gameinformation == null ? null : gameinformation.trim();
    }

    public Integer getGamenameid() {
        return gamenameid;
    }

    public void setGamenameid(Integer gamenameid) {
        this.gamenameid = gamenameid;
    }

    public Float getBettingamount() {
        return bettingamount;
    }

    public void setBettingamount(Float bettingamount) {
        this.bettingamount = bettingamount;
    }

    public Float getCompensaterate() {
        return compensaterate;
    }

    public void setCompensaterate(Float compensaterate) {
        this.compensaterate = compensaterate;
    }

    public Float getWinloseamount() {
        return winloseamount;
    }

    public void setWinloseamount(Float winloseamount) {
        this.winloseamount = winloseamount;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid == null ? null : vendorid.trim();
    }

    public Float getValidamount() {
        return validamount;
    }

    public void setValidamount(Float validamount) {
        this.validamount = validamount;
    }

    public Integer getGamekind() {
        return gamekind;
    }

    public void setGamekind(Integer gamekind) {
        this.gamekind = gamekind;
    }

    public Integer getPlatformid() {
        return platformid;
    }

    public void setPlatformid(Integer platformid) {
        this.platformid = platformid;
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