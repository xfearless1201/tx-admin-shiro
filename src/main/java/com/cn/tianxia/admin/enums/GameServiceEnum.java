package com.cn.tianxia.admin.enums;

import com.cn.tianxia.admin.service.ftpdata.BaseQueryService;
import com.cn.tianxia.admin.utils.SpringContextUtils;

public enum GameServiceEnum {

    /**
     * 视讯
     */
    //AG视讯
    AGIN("AGIN","AGINServiceImpl"),
    //BBIN视讯
    BBIN("BBIN","BBINServiceImpl"),
    //CG视讯
    CG("CG","CGServiceImpl"),
    //DS视讯
    DS("DS","DSServiceImpl"),
    //欧博视讯
    OB("OB","OBServiceImpl"),
    //OG视讯
    OG("OG","OGServiceImpl"),
    //申博视讯
    SB("SB","SBServiceImpl"),
    //BG视讯
    BG("BG","BGServiceImpl"),
    
    /**
     * 捕鱼
     */
   // AG("AG","AGINServiceImpl"),
    HUNTER("HUNTER","AGBYServiceImpl"),
    
    /**
     * 电子
     */
    //BBIN电子
    BBINGAME("BBINGAME","BBINGameRecordServiceImpl"),
    //申博电子
    SBGAME("SBGAME","SBGameRecordServiceImpl"),
    //MG电子
    MGGAME("MGGAME","MGGameRecordServiceImpl"),
    //HABA电子
    HBGAME("HBGAME","HBGameRecordServiceImpl"),
    //PT电子
    PTGAME("PTGAME","PTGameRecordServiceImpl"),
    //Yoplay电子
    YOPLAYGAME("YOPLAYGAME","yoplayGameRecordSereviceImpl"),
    //PS电子
    PSGAME("PSGAME","PSGameRecordServiceImpl"),
    //SW电子
    SWGAME("SWGAME","SWGameRecordServiceImpl"),
    //JDB电子
    JDBGAME("JDBGAME","JDBGameRecordServiceImpl"),
    //CQJ电子
    CQJGAME("CQJGAME","CQJGameRecordServiceImpl"),
    
    /**
     * 体育
     */
    IBCGAME("IBCGAME","IBCSportRecordServiceImpl"),
    ;
    
    private String gameType;
    private String mapper;
    
    GameServiceEnum(String gameType,String mapper){
      this.gameType = gameType;
      this.mapper = mapper;
  }
    
    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    
    public void setQueryService(String mapper) {
      this.mapper = mapper;
    }
    
    public BaseQueryService<?> getQueryService() throws Exception {
        return (BaseQueryService<?>) SpringContextUtils.getBean(this.mapper);
    }
}
