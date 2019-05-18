package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName SBGameRecord
 * @Description TODO(申博电子注单实体类)
 * @author Hardy
 * @Date 2019年5月17日 上午10:07:46
 * @version 1.0.0
 */
public class SBGameRecord extends ResultCommonField {
    private static final long serialVersionUID = -512161986024836499L;

    private Integer id;

    private String ugsbetid;

    private String txid;

    private String betid;

    private String beton;

    private String betclosedon;

    private String betupdatedon;

    private String timestamp;

    private String roundid;

    private String roundstatus;

    private String userid;

    private String username;

    private Float riskamt;

    private Float winamt;

    private Float winloss;

    private Float beforebal;

    private Float postbal;

    private String cur;

    private String gameprovider;

    private String gameprovidercode;

    private String gamename;

    private String gameid;

    private String platformtype;

    private String ipaddress;

    private String bettype;

    private String playtype;

    private String playertype;

    private String cagent;

    private Date pullTime;

    private Float rollingturnover;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUgsbetid() {
        return ugsbetid;
    }

    public void setUgsbetid(String ugsbetid) {
        this.ugsbetid = ugsbetid == null ? null : ugsbetid.trim();
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid == null ? null : txid.trim();
    }

    public String getBetid() {
        return betid;
    }

    public void setBetid(String betid) {
        this.betid = betid == null ? null : betid.trim();
    }

    public String getBeton() {
        return beton;
    }

    public void setBeton(String beton) {
        this.beton = beton == null ? null : beton.trim();
    }

    public String getBetclosedon() {
        return betclosedon;
    }

    public void setBetclosedon(String betclosedon) {
        this.betclosedon = betclosedon == null ? null : betclosedon.trim();
    }

    public String getBetupdatedon() {
        return betupdatedon;
    }

    public void setBetupdatedon(String betupdatedon) {
        this.betupdatedon = betupdatedon == null ? null : betupdatedon.trim();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.trim();
    }

    public String getRoundid() {
        return roundid;
    }

    public void setRoundid(String roundid) {
        this.roundid = roundid == null ? null : roundid.trim();
    }

    public String getRoundstatus() {
        return roundstatus;
    }

    public void setRoundstatus(String roundstatus) {
        this.roundstatus = roundstatus == null ? null : roundstatus.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Float getRiskamt() {
        return riskamt;
    }

    public void setRiskamt(Float riskamt) {
        this.riskamt = riskamt;
    }

    public Float getWinamt() {
        return winamt;
    }

    public void setWinamt(Float winamt) {
        this.winamt = winamt;
    }

    public Float getWinloss() {
        return winloss;
    }

    public void setWinloss(Float winloss) {
        this.winloss = winloss;
    }

    public Float getBeforebal() {
        return beforebal;
    }

    public void setBeforebal(Float beforebal) {
        this.beforebal = beforebal;
    }

    public Float getPostbal() {
        return postbal;
    }

    public void setPostbal(Float postbal) {
        this.postbal = postbal;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur == null ? null : cur.trim();
    }

    public String getGameprovider() {
        return gameprovider;
    }

    public void setGameprovider(String gameprovider) {
        this.gameprovider = gameprovider == null ? null : gameprovider.trim();
    }

    public String getGameprovidercode() {
        return gameprovidercode;
    }

    public void setGameprovidercode(String gameprovidercode) {
        this.gameprovidercode = gameprovidercode == null ? null : gameprovidercode.trim();
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid == null ? null : gameid.trim();
    }

    public String getPlatformtype() {
        return platformtype;
    }

    public void setPlatformtype(String platformtype) {
        this.platformtype = platformtype == null ? null : platformtype.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public String getBettype() {
        return bettype;
    }

    public void setBettype(String bettype) {
        this.bettype = bettype == null ? null : bettype.trim();
    }

    public String getPlaytype() {
        return playtype;
    }

    public void setPlaytype(String playtype) {
        this.playtype = playtype == null ? null : playtype.trim();
    }

    public String getPlayertype() {
        return playertype;
    }

    public void setPlayertype(String playertype) {
        this.playertype = playertype == null ? null : playertype.trim();
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

    public Float getRollingturnover() {
        return rollingturnover;
    }

    public void setRollingturnover(Float rollingturnover) {
        this.rollingturnover = rollingturnover;
    }
}