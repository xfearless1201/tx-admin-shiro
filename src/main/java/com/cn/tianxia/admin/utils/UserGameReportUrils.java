package com.cn.tianxia.admin.utils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.tianxia.admin.enums.GameTableEnum;
import com.cn.tianxia.admin.project.txdata.DicData;
import com.cn.tianxia.admin.project.txdata.WinDetails;
import com.cn.tianxia.admin.service.ftpdata.GameDataService;
import com.cn.tianxia.admin.vo.ftpdata.WinDetailsVO;

/**
 * 
 * @ClassName UserGameReportUrils
 * @Description TODO(查询会员游戏汇总数据工具类)
 * @author Toby
 * @Date 2019年5月8日 下午4:06:52
 * @version 1.0.0
 */
@Component
public class UserGameReportUrils {

	/**
	 * 跨库查询游戏详情类
	 */
	@Autowired
	private GameDataService gameDataService;
	
	// 日志
	private static final Logger logger = LoggerFactory.getLogger(UserGameReportUrils.class);
	
	/**
	 * 
	 * @Description (按照会员 查询所有游戏注单汇总)
	 * @param dicData 数据字典集合 
	 * @param WinDetailsList 返回的集合
	 * @param winDeta 参数封装 
	 */
	public void userGameSummary(List<DicData> dicData, List<WinDetails> WinDetailsList,
			WinDetailsVO winDeta) {

		dicData.parallelStream().forEach(dicDataid -> {
			/**
			 * 游戏详情VO
			 */
			winDeta.setCode(dicDataid.getCode());
			winDeta.setType(0);

			if ("AGHSR".equals(dicDataid.getCode())) {
				winDeta.setType(1);
				winDeta.setGameTable(GameTableEnum.valueOf("AG").getMapper());
			} else if ("BBIN".equals(dicDataid.getCode())) {
				winDeta.setType(1);
				winDeta.setGameTable(GameTableEnum.valueOf("BBIN").getMapper());
			} else if ("BBINGAME".equals(dicDataid.getCode())) {
				winDeta.setType(0);
				winDeta.setGameTable(GameTableEnum.valueOf("BBIN").getMapper());
			} else if ("IG".equals(dicDataid.getCode())) {
				winDeta.setType(1);
				winDeta.setGameTable(GameTableEnum.valueOf("IG").getMapper());
			} else if ("IGHK".equals(dicDataid.getCode())) {
				winDeta.setType(2);
				winDeta.setGameTable(GameTableEnum.valueOf("IG").getMapper());
			} else if ("IGPJ".equals(dicDataid.getCode())) {
				winDeta.setType(1);
				winDeta.setGameTable(GameTableEnum.valueOf("IGPJ").getMapper());
			} else if ("IGPJHK".equals(dicDataid.getCode())) {
				winDeta.setType(2);
				winDeta.setGameTable(GameTableEnum.valueOf("IGPJ").getMapper());
			} else if ("IMTY".equals(dicDataid.getCode())) {
				winDeta.setType(301);
				winDeta.setGameTable(GameTableEnum.valueOf("IMTY").getMapper());
			} else if ("IMGAME".equals(dicDataid.getCode())) {
				winDeta.setType(401);
				winDeta.setGameTable(GameTableEnum.valueOf("IMGAME").getMapper());
			} else if ("BGVIDEO".equals(dicDataid.getCode())) {
				winDeta.setGameTable(GameTableEnum.valueOf("BGVIDEO").getMapper());
			} else if ("BGLOTTERY".equals(dicDataid.getCode())) {
				winDeta.setGameTable(GameTableEnum.valueOf("BGLOTTERY").getMapper());
			} else if ("YOPLAY".equals(dicDataid.getCode())) {
				winDeta.setGameTable(GameTableEnum.valueOf("YOPLAY").getMapper());
			} else if ("SPTA".equals(dicDataid.getCode())) {
				winDeta.setGameTable(GameTableEnum.valueOf("SPTA").getMapper());
			} else {
				winDeta.setGameTable(
						dicDataid.getCode().toLowerCase() + GameTableEnum.valueOf("PLATFORM_REPORT").getMapper());
			}
			logger.info("查询用会员注单汇总:{}", winDeta.toString());
			/**
			 * 动态查询游戏注单汇总表
			 */
			List<WinDetails> winDetailObject = gameDataService.selectWinDetails(winDeta);
			if (winDetailObject != null && winDetailObject.size() != 0) {
				winDetailObject.parallelStream().forEach(winList -> {
					formatData(winList);
					if(null != winDeta.getBetTime()){
						winList.setPlatformName(dicDataid.getName());
					}
				});
				WinDetailsList.addAll(winDetailObject);
			}
		});
	}
	
	/**
	 * 
	 * @Description (时间转换工具类)
	 * @param winList
	 */
	public void formatData(WinDetails winList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			winList.setBetTime(sdf.format(sdf.parse(winList.getBetTime())));
		} catch (Exception e1) {
			logger.info("时间转换异常:{}", e1.getMessage());
			e1.printStackTrace();
		}
	}
	
}
