package com.cn.tianxia.admin.project.txdata;

import lombok.Data;

/**
 * 
 * @ClassName WinDetails
 * @Description TODO(会员输赢详情)
 * @author Toby
 * @Date 2019年5月6日 下午7:35:20
 * @version 1.0.0
 */
@Data
public class WinDetails {

	
	/**
	 * 会员ID
	 */
	private Integer uid;
	/**
	 * id
	 */
	private Integer id;

	/**
	 * 会员账号
	 */
	private String username;
	/**
	 * 时间
	 */
	private String betTime;

	/**
	 * 注单数
	 */
	private Integer noteNum;

	/**
	 * 有效注单数
	 */
	private Integer validNoteNum;

	/**
	 * 下注金额
	 */
	private Double betAmount;

	/**
	 * 有效投注额
	 */
	private Double validBetAmount;

	/**
	 * 输赢金额
	 */
	private Double netAmount;

	/**
	 * 加款金额
	 */
	private Double addMoney;

	/**
	 * 存款金额
	 */
	private Double deposit;

	/**
	 * 提款金额
	 */
	private Double withdRawal;

	/**
	 * 返水金额
	 */
	private Double returnWater;

	/**
	 * 奖金
	 */
	private Double revenue;

	/**
	 * 平台号
	 */
	private String cagent;

	/**
	 * 扣款金额
	 */
	private Double deductMoney;
	
	/**
	 * 币种
	 */
	private String currency;
	
	/**
	 * 注单类型
	 */
	private Integer type;
	
	/**
	 * 游戏平台名称
	 */
	private String platformName;

}