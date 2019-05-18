package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName YoPlayGameRecord
 * @Description TODO(Yoplay电子实体类)
 * @author Hardy
 * @Date 2019年5月17日 下午9:32:41
 * @version 1.0.0
 */
public class YoPlayGameRecord extends ResultCommonField{
    private static final long serialVersionUID = 837265712784786657L;

    private Integer id;

    private String billno;

    private String playername;

    private String agentcode;

    private String gamecode;

    private Float netamount;

    private Date bettime;

    private String gametype;

    private Float betamount;

    private Float validbetamount;

    private String flag;

    private String playtype;

    private String currency;

    private String tablecode;

    private String loginip;

    private Date recalcutime;

    private String platformtype;

    private String remark;

    private String round;

    private String slottype;

    private String result;

    private String mainbillno;

    private Float beforecredit;

    private Float betamountbase;

    private Float betamountbonus;

    private Float netamountbase;

    private Float netamountbonus;

    private String devicetype;

    private String cagent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername == null ? null : playername.trim();
    }

    public String getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(String agentcode) {
        this.agentcode = agentcode == null ? null : agentcode.trim();
    }

    public String getGamecode() {
        return gamecode;
    }

    public void setGamecode(String gamecode) {
        this.gamecode = gamecode == null ? null : gamecode.trim();
    }

    public Float getNetamount() {
        return netamount;
    }

    public void setNetamount(Float netamount) {
        this.netamount = netamount;
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public Float getBetamount() {
        return betamount;
    }

    public void setBetamount(Float betamount) {
        this.betamount = betamount;
    }

    public Float getValidbetamount() {
        return validbetamount;
    }

    public void setValidbetamount(Float validbetamount) {
        this.validbetamount = validbetamount;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getPlaytype() {
        return playtype;
    }

    public void setPlaytype(String playtype) {
        this.playtype = playtype == null ? null : playtype.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getTablecode() {
        return tablecode;
    }

    public void setTablecode(String tablecode) {
        this.tablecode = tablecode == null ? null : tablecode.trim();
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public Date getRecalcutime() {
        return recalcutime;
    }

    public void setRecalcutime(Date recalcutime) {
        this.recalcutime = recalcutime;
    }

    public String getPlatformtype() {
        return platformtype;
    }

    public void setPlatformtype(String platformtype) {
        this.platformtype = platformtype == null ? null : platformtype.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round == null ? null : round.trim();
    }

    public String getSlottype() {
        return slottype;
    }

    public void setSlottype(String slottype) {
        this.slottype = slottype == null ? null : slottype.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getMainbillno() {
        return mainbillno;
    }

    public void setMainbillno(String mainbillno) {
        this.mainbillno = mainbillno == null ? null : mainbillno.trim();
    }

    public Float getBeforecredit() {
        return beforecredit;
    }

    public void setBeforecredit(Float beforecredit) {
        this.beforecredit = beforecredit;
    }

    public Float getBetamountbase() {
        return betamountbase;
    }

    public void setBetamountbase(Float betamountbase) {
        this.betamountbase = betamountbase;
    }

    public Float getBetamountbonus() {
        return betamountbonus;
    }

    public void setBetamountbonus(Float betamountbonus) {
        this.betamountbonus = betamountbonus;
    }

    public Float getNetamountbase() {
        return netamountbase;
    }

    public void setNetamountbase(Float netamountbase) {
        this.netamountbase = netamountbase;
    }

    public Float getNetamountbonus() {
        return netamountbonus;
    }

    public void setNetamountbonus(Float netamountbonus) {
        this.netamountbonus = netamountbonus;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype == null ? null : devicetype.trim();
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }
}