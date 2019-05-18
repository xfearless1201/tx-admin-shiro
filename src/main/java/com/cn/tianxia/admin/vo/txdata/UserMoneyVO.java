package com.cn.tianxia.admin.vo.txdata;

import lombok.Data;

/**
 * 
 * @ClassName UserMoneyVO
 * @Description TODO(手动加款VO)
 * @author Toby
 * @Date 2019年5月14日 下午4:15:34
 * @version 1.0.0
 */
@Data
public class UserMoneyVO {
	
	/**
	 * 会员积分比例
	 */
	private Float cIntegralRatio;
	
	/**
	 * 优惠
	 */
	private Float companyPayProp;
	
	/**
	 * 彩金
	 */
	private Float giftBonusProp;
	
	/**
	 * 打码量
	 */
	private Float dama;
}
 