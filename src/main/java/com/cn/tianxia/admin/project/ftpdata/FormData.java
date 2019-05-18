package com.cn.tianxia.admin.project.ftpdata;

import java.io.Serializable;

/**
 * 表单查询条件
 * @author Administrator
 *
 */
public class FormData implements Serializable{
    
    /**
     * 序列化唯一标识
     */
    private static final long serialVersionUID = -2591359892712257238L;
    
    /**
     * 平台商名称
     */
    private String cagentName;
    /**
     * 平台ID,用来查询游戏类型
     * 视讯  AGIN=1 BBIN=3 CG=5 DS=6 OB=12 OG=13 SB=15 BG没有
     * 电子 BBINGAME=4 SBGAME=16 MGGAME=11 HBGAME=8 PTGAME=14 YOPLAYGAME=21 PSGAME=25 SWGAME=29 JDBGAME=28 CQJGAME=32
     * 体育 IBCGAME=30
     */
    private Integer platFormId;
    
    /**
     * 查询条件 0 按会员账号 1 用户姓名 2 代理商 3 会员分层
     */
    private int queryType;
    
    /**
     * 查询条件值 与queryType 相关, queryType=0 则name表示会员账号值
     */
    private String name ;
//  /**
//   * 会员账号
//   */
//  private String userName;
//  /**
//   * 用户姓名
//   */
//  private String realname;
//  /**
//   * 代理商
//   */
//  private String topUidName;
//  /**
//   * 会员分层
//   */
//  private String userTypeName;
    /**
     * 服务类型,该值决定调用哪个service查询
     */
    private String gameType;
    /**
     * 游戏平台 比如AG有AG视讯，和AG国际
     * 或者 游戏类型  比如申博有电子，老虎机类型
     * 或者过关注单 =29 普通注单不等于29
     */
    private String gamePlatFormName;
    /**
     * 具体游戏，比如游戏类型 老虎机  包含幸运龙，变脸等游戏
     */
    private String mtype;
    /**
     * 结算状态  默认全部 null表示全部 0已结算 1未结算 ……
     */
    private Integer flag;
    /**
     * 按什么时间查询，比如申博电子有按下注时间 和结算时间查询 体育有比赛时间
     * 0 表示下注时间 1表示结算时间 .... 
     */
    private int timeType;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 当前第几页
     */
    private int page;
    /**
     * 每页显示多少行
     */
    private int rows;
    
    /**
     * 是否会员分组 默认不分组 0, 分组1
     */
    private int userGrouping;
    
    /**
     * 是否实时分页 默认不实时 0, 实时1
     */
    private int dateGrouping;
    
    public String getCagentName() {
        return cagentName;
    }
    public void setCagentName(String cagentName) {
        this.cagentName = cagentName;
    }
    public Integer getPlatFormId() {
        return platFormId;
    }
    public void setPlatFormId(Integer platFormId) {
        this.platFormId = platFormId;
    }
//  public String getUserName() {
//      return userName;
//  }
//  public void setUserName(String userName) {
//      this.userName = userName;
//  }
//  public String getRealname() {
//      return realname;
//  }
//  public void setRealname(String realname) {
//      this.realname = realname;
//  }
//  public String getTopUidName() {
//      return topUidName;
//  }
//  public void setTopUidName(String topUidName) {
//      this.topUidName = topUidName;
//  }
//  public String getUserTypeName() {
//      return userTypeName;
//  }
//  public void setUserTypeName(String userTypeName) {
//      this.userTypeName = userTypeName;
//  }
    public String getGameType() {
        return gameType;
    }
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getUserGrouping() {
        return userGrouping;
    }
    public void setUserGrouping(int userGrouping) {
        this.userGrouping = userGrouping;
    }
    public int getDateGrouping() {
        return dateGrouping;
    }
    public void setDateGrouping(int dateGrouping) {
        this.dateGrouping = dateGrouping;
    }
//    public boolean userGrouping(){
//        return this.userGrouping != null;
//    }
//    public boolean dateGrouping(){
//        return this.dateGrouping != null;
//    }
    public String getGamePlatFormName() {
        return gamePlatFormName;
    }
    public void setGamePlatFormName(String gamePlatFormName) {
        this.gamePlatFormName = gamePlatFormName;
    }
    public int getQueryType() {
        return queryType;
    }
    public void setQueryType(int queryType) {
        this.queryType = queryType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTimeType() {
        return timeType;
    }
    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }
    public String getMtype() {
        return mtype;
    }
    public void setMtype(String mtype) {
        this.mtype = mtype;
    }
    public Integer getFlag() {
        return flag;
    }
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
