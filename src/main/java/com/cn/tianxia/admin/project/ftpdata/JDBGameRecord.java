package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName JDBGameRecord
 * @Description TODO(JDB电子实体类)
 * @author Hardy
 * @Date 2019年5月18日 下午4:19:23
 * @version 1.0.0
 */
public class JDBGameRecord extends ResultCommonField{
    private static final long serialVersionUID = 8620000694245420276L;

    private Integer id;

    private Long seqno;

    private String playerid;

    private Integer mtype;

    private Integer roomtype;

    private Double beforebalance;

    private Double afterbalance;

    private Date gamedate;

    private Double bet;

    private Double gamblebet;

    private Double win;

    private Double total;

    private String currency;

    private Double jackpot;

    private Double jackpotcontribute;

    private Double denom;

    private Date lastmodifytime;

    private String playerip;

    private String clienttype;

    private Integer hasfreegame;

    private Integer hasgamble;

    private Integer hasbonusgame;

    private Integer systemtakewin;

    private String cagent;

    private String errText;

    private Double validbet;

    private Integer gtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid == null ? null : playerid.trim();
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    public Double getBeforebalance() {
        return beforebalance;
    }

    public void setBeforebalance(Double beforebalance) {
        this.beforebalance = beforebalance;
    }

    public Double getAfterbalance() {
        return afterbalance;
    }

    public void setAfterbalance(Double afterbalance) {
        this.afterbalance = afterbalance;
    }

    public Date getGamedate() {
        return gamedate;
    }

    public void setGamedate(Date gamedate) {
        this.gamedate = gamedate;
    }

    public Double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public Double getGamblebet() {
        return gamblebet;
    }

    public void setGamblebet(Double gamblebet) {
        this.gamblebet = gamblebet;
    }

    public Double getWin() {
        return win;
    }

    public void setWin(Double win) {
        this.win = win;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Double getJackpot() {
        return jackpot;
    }

    public void setJackpot(Double jackpot) {
        this.jackpot = jackpot;
    }

    public Double getJackpotcontribute() {
        return jackpotcontribute;
    }

    public void setJackpotcontribute(Double jackpotcontribute) {
        this.jackpotcontribute = jackpotcontribute;
    }

    public Double getDenom() {
        return denom;
    }

    public void setDenom(Double denom) {
        this.denom = denom;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getPlayerip() {
        return playerip;
    }

    public void setPlayerip(String playerip) {
        this.playerip = playerip == null ? null : playerip.trim();
    }

    public String getClienttype() {
        return clienttype;
    }

    public void setClienttype(String clienttype) {
        this.clienttype = clienttype == null ? null : clienttype.trim();
    }

    public Integer getHasfreegame() {
        return hasfreegame;
    }

    public void setHasfreegame(Integer hasfreegame) {
        this.hasfreegame = hasfreegame;
    }

    public Integer getHasgamble() {
        return hasgamble;
    }

    public void setHasgamble(Integer hasgamble) {
        this.hasgamble = hasgamble;
    }

    public Integer getHasbonusgame() {
        return hasbonusgame;
    }

    public void setHasbonusgame(Integer hasbonusgame) {
        this.hasbonusgame = hasbonusgame;
    }

    public Integer getSystemtakewin() {
        return systemtakewin;
    }

    public void setSystemtakewin(Integer systemtakewin) {
        this.systemtakewin = systemtakewin;
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public String getErrText() {
        return errText;
    }

    public void setErrText(String errText) {
        this.errText = errText == null ? null : errText.trim();
    }

    public Double getValidbet() {
        return validbet;
    }

    public void setValidbet(Double validbet) {
        this.validbet = validbet;
    }

    public Integer getGtype() {
        return gtype;
    }

    public void setGtype(Integer gtype) {
        this.gtype = gtype;
    }
}