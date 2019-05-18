package com.cn.tianxia.admin.domain.ftpdata;

import java.util.List;

import com.cn.tianxia.admin.project.txdata.WinDetails;
import com.cn.tianxia.admin.vo.ftpdata.WinDetailsVO;

/**
 * 
 * @ClassName GameDataMapper
 * @Description TODO(跨库查询游戏详情Map)
 * @author Toby
 * @Date 2019年5月6日 下午7:51:02
 * @version 1.0.0
 */
public interface GameDataMapper{

	/**
	 * 
	 * @Description (查询会员输赢详情)
	 * @param winDeta
	 * @return
	 */
	List<WinDetails> selectWinDetails(WinDetailsVO winDeta);

}