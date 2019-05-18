package com.cn.tianxia.admin.project.ftpdata;

import java.util.Date;

/**
 * 
 * @ClassName AgBr
 * @Description TODO(AgBr实体类)
 * @author Hardy
 * @Date 2019年5月7日 下午9:19:30
 * @version 1.0.0
 */
public class AgBr extends ResultCommonField{
    
    private static final long serialVersionUID = -2692955371328109840L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 注单流水号(满足平台的唯一约束条件)
     */
    private String billno;

    /**
     * 玩家账号
     */
    private String playername;

    /**
     * 代理商编号
     */
    private String agentcode;

    /**
     * 游戏局号
     */
    private String gamecode;

    /**
     * 玩家输赢额度
     */
    private Float netamount;

    /**
     * 投注时间
     */
    private Date bettime;

    /**
     * 游戏类型 和ag_gametype表关联
     */
    private String gametype;

    /**
     * 投注金额
     */
    private Float betamount;

    /**
     * 有效投注额
     */
    private Float validbetamount;

    /**
     * 结算状态 和ag_flag表关联
     */
    private String flag;

    /**
     * 游戏玩法 和ag_playtype表关联
     */
    private String playtype;

    /**
     * 货币类型和ag_currency表关联
     */
    private String currency;

    /**
     * 桌子编号
     */
    private String tablecode;

    /**
     * 玩家 IP
     */
    private String loginip;

    /**
     * 注单重新派彩时间
     */
    private Date recalcutime;

    /**
     * 平台编号(通常为空)
     */
    private String platformid;

    /**
     * 平台类型 和ag_platform表关联
     */
    private String platformtype;

    /**
     * 产品附注(通常为空)
     * 
     */
    private String stringex;

    /**
     * 额外信息\r\nBBIN 平台的數據類型\r\n1=BB 體育\r\n3=視訊\r\n5=機率\r\n12=彩票\r\n15=3D 廳\r\n30=BB 捕魚機\r\n99=小費\r
     */
    private String remark;

    /**
     * 平台内的大厅类型 和ag_round表关联
     */
    private String round;

    /**
     * 下注记录
     */
    private String datatype;

    /**
     * 代理商
     */
    private String cagent;

    /**
     * 拉取时间
     */
    private Date pullIme;

    /**
     * 庄家点
     */
    private String bankerpoint;

    /**
     * 闲家点
     */
    private String playerpoint;

    /**
     * 龙点数
     */
    private String dragonpoint;

    /**
     * 虎点数
     */
    private String tigerpoint;

    /**
     * '是否更新 0:否,1:是
     */
    private Byte isUpdate;

    /**
     * 发牌资料
     */
    private String cardlist;

    /**
     * 真实的游戏类型
     */
    private String realgametype;
    
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

    public String getPlatformid() {
        return platformid;
    }

    public void setPlatformid(String platformid) {
        this.platformid = platformid == null ? null : platformid.trim();
    }

    public String getPlatformtype() {
        return platformtype;
    }

    public void setPlatformtype(String platformtype) {
        this.platformtype = platformtype == null ? null : platformtype.trim();
    }

    public String getStringex() {
        return stringex;
    }

    public void setStringex(String stringex) {
        this.stringex = stringex == null ? null : stringex.trim();
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

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public Date getPullIme() {
        return pullIme;
    }

    public void setPullIme(Date pullIme) {
        this.pullIme = pullIme;
    }

    public String getBankerpoint() {
        return bankerpoint;
    }

    public void setBankerpoint(String bankerpoint) {
        this.bankerpoint = bankerpoint == null ? null : bankerpoint.trim();
    }

    public String getPlayerpoint() {
        return playerpoint;
    }

    public void setPlayerpoint(String playerpoint) {
        this.playerpoint = playerpoint == null ? null : playerpoint.trim();
    }

    public String getDragonpoint() {
        return dragonpoint;
    }

    public void setDragonpoint(String dragonpoint) {
        this.dragonpoint = dragonpoint == null ? null : dragonpoint.trim();
    }

    public String getTigerpoint() {
        return tigerpoint;
    }

    public void setTigerpoint(String tigerpoint) {
        this.tigerpoint = tigerpoint == null ? null : tigerpoint.trim();
    }

    public Byte getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Byte isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getCardlist() {
        return cardlist;
    }

    public void setCardlist(String cardlist) {
        this.cardlist = cardlist == null ? null : cardlist.trim();
    }

    public String getRealgametype() {
        return realgametype;
    }

    public void setRealgametype(String realgametype) {
        this.realgametype = realgametype == null ? null : realgametype.trim();
    }
}