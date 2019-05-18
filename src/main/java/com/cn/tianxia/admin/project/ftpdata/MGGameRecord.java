package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;
/**
 * 
 * @ClassName MGGameRecord
 * @Description TODO(MG电子实体类)
 * @author Hardy
 * @Date 2019年5月17日 下午3:43:53
 * @version 1.0.0
 */
public class MGGameRecord extends ResultCommonField{
    private static final long serialVersionUID = 1979070490864485943L;

    private Integer id;

    private String key;

    private Long colid;

    private String hornekey;

    private String mbrnekey;

    private String bettranskey;

    private String gamekey;

    private String type;

    private String product;

    private Date transactiontimestampdate;

    private Float amount;

    private String mbrcode;

    private String mbralias;

    private String mbrusername;

    private String gamecasinoid;

    private String gamepokerid;

    private String gamepokertype;

    private String refkey;

    private String reftype;

    private Float aftertxwalletamount;

    private String mgsgameid;

    private String mgsactionid;

    private Float clrngamnt;

    private String gameplatformtype;

    private String cagent;

    private Date pullTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public Long getColid() {
        return colid;
    }

    public void setColid(Long colid) {
        this.colid = colid;
    }

    public String getHornekey() {
        return hornekey;
    }

    public void setHornekey(String hornekey) {
        this.hornekey = hornekey == null ? null : hornekey.trim();
    }

    public String getMbrnekey() {
        return mbrnekey;
    }

    public void setMbrnekey(String mbrnekey) {
        this.mbrnekey = mbrnekey == null ? null : mbrnekey.trim();
    }

    public String getBettranskey() {
        return bettranskey;
    }

    public void setBettranskey(String bettranskey) {
        this.bettranskey = bettranskey == null ? null : bettranskey.trim();
    }

    public String getGamekey() {
        return gamekey;
    }

    public void setGamekey(String gamekey) {
        this.gamekey = gamekey == null ? null : gamekey.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public Date getTransactiontimestampdate() {
        return transactiontimestampdate;
    }

    public void setTransactiontimestampdate(Date transactiontimestampdate) {
        this.transactiontimestampdate = transactiontimestampdate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getMbrcode() {
        return mbrcode;
    }

    public void setMbrcode(String mbrcode) {
        this.mbrcode = mbrcode == null ? null : mbrcode.trim();
    }

    public String getMbralias() {
        return mbralias;
    }

    public void setMbralias(String mbralias) {
        this.mbralias = mbralias == null ? null : mbralias.trim();
    }

    public String getMbrusername() {
        return mbrusername;
    }

    public void setMbrusername(String mbrusername) {
        this.mbrusername = mbrusername == null ? null : mbrusername.trim();
    }

    public String getGamecasinoid() {
        return gamecasinoid;
    }

    public void setGamecasinoid(String gamecasinoid) {
        this.gamecasinoid = gamecasinoid == null ? null : gamecasinoid.trim();
    }

    public String getGamepokerid() {
        return gamepokerid;
    }

    public void setGamepokerid(String gamepokerid) {
        this.gamepokerid = gamepokerid == null ? null : gamepokerid.trim();
    }

    public String getGamepokertype() {
        return gamepokertype;
    }

    public void setGamepokertype(String gamepokertype) {
        this.gamepokertype = gamepokertype == null ? null : gamepokertype.trim();
    }

    public String getRefkey() {
        return refkey;
    }

    public void setRefkey(String refkey) {
        this.refkey = refkey == null ? null : refkey.trim();
    }

    public String getReftype() {
        return reftype;
    }

    public void setReftype(String reftype) {
        this.reftype = reftype == null ? null : reftype.trim();
    }

    public Float getAftertxwalletamount() {
        return aftertxwalletamount;
    }

    public void setAftertxwalletamount(Float aftertxwalletamount) {
        this.aftertxwalletamount = aftertxwalletamount;
    }

    public String getMgsgameid() {
        return mgsgameid;
    }

    public void setMgsgameid(String mgsgameid) {
        this.mgsgameid = mgsgameid == null ? null : mgsgameid.trim();
    }

    public String getMgsactionid() {
        return mgsactionid;
    }

    public void setMgsactionid(String mgsactionid) {
        this.mgsactionid = mgsactionid == null ? null : mgsactionid.trim();
    }

    public Float getClrngamnt() {
        return clrngamnt;
    }

    public void setClrngamnt(Float clrngamnt) {
        this.clrngamnt = clrngamnt;
    }

    public String getGameplatformtype() {
        return gameplatformtype;
    }

    public void setGameplatformtype(String gameplatformtype) {
        this.gameplatformtype = gameplatformtype == null ? null : gameplatformtype.trim();
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