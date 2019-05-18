package com.cn.tianxia.admin.enums;

import com.cn.tianxia.admin.service.ftpdata.BaseQueryService;
import com.cn.tianxia.admin.utils.SpringContextUtils;

/**
 * 
 * @ClassName GameTableEnum
 * @Description TODO(游戏数据表枚举)
 * @author Toby
 * @Date 2019年5月7日 上午9:20:07
 * @version 1.0.0
 */
public enum GameTableEnum {

	AG("AG","ag_platform_report"),
    BBIN("BBIN","bbin_platform_report"),
    IG("IG","ig_platform_report"),
    IGPJ("IGPJ","igpj_platform_report"),
    IMGAME("IMGAME","im_platform_report"),
    IMTY("IMTY","im_platform_report"),
    BGVIDEO("BGVIDEO","bg_video_platform_report"),
    BGLOTTERY("BGLOTTERY","bg_lottery_platform_report"),
    YOPLAY("YOPLAY","bg_lottery_platform_report"),
    SPTA("SPTA","ag_ty_platform_report"),
    PLATFORM_REPORT("platform","_platform_report"),
    ;
    
    private String gameType;
    private String mapper;
    
    GameTableEnum(String gameType,String mapper){
      this.gameType = gameType;
      this.mapper = mapper;
  }
    
    public String getGameType() {
        return gameType;
    }
    
    public String getMapper() {
		return mapper;
	}

	public void setMapper(String mapper) {
		this.mapper = mapper;
	}

	public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    
    public void setQueryService(String mapper) {
      this.mapper = mapper;
    }
    
    public BaseQueryService getQueryService() throws Exception {
        return (BaseQueryService) SpringContextUtils.getBean(this.mapper);
    }
}
