package com.cn.tianxia.admin.vo.ftpdata;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @ClassName WinDetailsVO
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Toby
 * @Date 2019年5月7日 上午9:09:59
 * @version 1.0.0
 */
@Data
public class WinDetailsVO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 会员uid
	 */
	private Integer uid;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 结算时间
	 */
	private String endTime;

	/**
	 * 单日时间
	 */
	private String betTime;
	/**
	 * 类型  默认0  其他类型根据汇总表定
	 */
	private Integer type;
	
	/**
	 * 注单汇总表
	 */
	private String gameTable;
	
	/**
	 * 游戏平台CODE
	 */
	private String code;
	
	/**
	 * 平台商
	 */
	private String cagent;
}

