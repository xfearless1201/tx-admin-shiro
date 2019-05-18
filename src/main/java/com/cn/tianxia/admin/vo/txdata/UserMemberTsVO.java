package com.cn.tianxia.admin.vo.txdata;

import lombok.Data;

/**
 * 
 * @ClassName UserMemberTsVO
 * @Description TODO(会员退水)
 * @author Toby
 * @Date 2019年5月17日 下午8:02:29
 * @version 1.0.0
 */
@Data
public class UserMemberTsVO {

	/**
	 * 会员ID
	 */
	private Integer uid;
	
	/**
	 * 游戏平台类型
	 */
	private String gametype;
	
	/**
	 * 游戏平台名字
	 */
	private String gamaValue;
	
	/**
	 * 平台商
	 */
	private String cagent;
}
