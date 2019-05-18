package com.cn.tianxia.admin.service.txdata.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.DicDataMapper;
import com.cn.tianxia.admin.domain.txdata.UserPlatformReportMapper;
import com.cn.tianxia.admin.project.txdata.DicData;
import com.cn.tianxia.admin.project.txdata.UserPlatformReport;
import com.cn.tianxia.admin.service.txdata.UserPlatformReportService;

@Service
public class UserPlatformReportImpl implements UserPlatformReportService {

	// 日志
	private static final Logger logger = LoggerFactory.getLogger(UserPlatformReportImpl.class);

	@Autowired
	private UserPlatformReportMapper userPlatformReportMapper;

	/**
	 * 数据字典
	 */
	@Autowired
	private DicDataMapper dicDataMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userPlatformReportMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(UserPlatformReport record) {
		return userPlatformReportMapper.insertSelective(record);
	}

	@Override
	public UserPlatformReport selectByPrimaryKey(Integer id) {
		return userPlatformReportMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserPlatformReport record) {
		return userPlatformReportMapper.updateByPrimaryKeySelective(record);
	}

	/**
     * 根据UID查询会员 各游戏平台注单汇总
     */
//    @DataSource(Database.TXDATA_DB_SLAVE)
	@Override
	public Pager<UserPlatformReport> selectByUid(Integer uid) throws Exception{
		
		logger.info("查询用会员各游戏平台注单汇总:{}", uid);
		// 根据UID查询会员 各游戏平台注单汇总
		List<UserPlatformReport> userPlatformReport = userPlatformReportMapper.selectByUid(uid);
		
		/**
		 * 获取数据字段游戏列表
		 */
		List<DicData> dicData = dicDataMapper.selectDicData();
		/**
		 * 将所有游戏类型转入MAP集合
		 */
		Map<String,Object> dicMap = new HashMap<String,Object>();
		for (DicData dicData2 : dicData) {
			dicMap.put(dicData2.getCode().toUpperCase(), dicData2.getName());
		}
		/**
		 * 拼接游戏平台，并且删除MAP中存在的游戏平台
		 */
		for (UserPlatformReport userPlatObject : userPlatformReport) {
			if(dicMap.containsKey(userPlatObject.getPlatformType().toUpperCase().toString())){
				userPlatObject.setPlatformName(dicMap.remove(userPlatObject.getPlatformType().toUpperCase().toString()).toString());
				userPlatObject.setPlatformType(userPlatObject.getPlatformType().toUpperCase());
    		}
		}
		/**
		 * 添加没有数据的平台
		 */
    	for(Entry<String, Object> entry:dicMap.entrySet()){
    		UserPlatformReport tempMap=new UserPlatformReport();
    		tempMap.setPlatformType(entry.getKey());
    		tempMap.setPlatformName(entry.getValue().toString());
    		tempMap.setCurrency("CNY");
    		tempMap.setNoteNum(0);
    		tempMap.setBetAmount(0d);
    		tempMap.setValidBetAmount(0d);
    		tempMap.setNetAmount(0d);
    		tempMap.setBetTime(new Date());
    		tempMap.setCagent("");
    		userPlatformReport.add(tempMap);
    	}
    	
    	/**
    	 * 排序
    	 */
    	Collections.sort(userPlatformReport, new Comparator<UserPlatformReport>() {
			@Override
			public int compare(UserPlatformReport o1, UserPlatformReport o2) {
				return o1.getPlatformType().compareTo(o2.getPlatformType().toString());
			}
		     
	    });
    	
    	/**
    	 * 添加总计
    	 */
    		
    		UserPlatformReport platFromCount = new UserPlatformReport();
    		
    		/**
    		 * 注单数
    		 */
    		IntSummaryStatistics notNum = userPlatformReport.stream()
					.mapToInt(value -> value.getNoteNum()).summaryStatistics();

    		platFromCount.setNoteNum(Integer.parseInt(notNum.getSum()+""));
			
			/**
			 * 投注额
			 */
			DoubleSummaryStatistics betAmount = userPlatformReport.stream()
					.mapToDouble(value -> value.getBetAmount()).summaryStatistics();
			platFromCount.setBetAmount(betAmount.getSum());	
			
			/**
			 * 有效投注额
			 */
			
			DoubleSummaryStatistics validBetAmount = userPlatformReport.stream()
					.mapToDouble(value -> value.getValidBetAmount()).summaryStatistics();
			platFromCount.setValidBetAmount(validBetAmount.getSum());	
			
			/**
			 * 输赢额
			 */
			DoubleSummaryStatistics netAmount = userPlatformReport.stream()
					.mapToDouble(value -> value.getNetAmount()).summaryStatistics();
			platFromCount.setNetAmount(netAmount.getSum());	
			
			userPlatformReport.add(platFromCount);
			
		Pager<UserPlatformReport> result = new Pager<>();
		result.setList(userPlatformReport);
		return result;
	}

}
