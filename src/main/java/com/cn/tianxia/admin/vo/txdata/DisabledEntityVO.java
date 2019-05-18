package com.cn.tianxia.admin.vo.txdata;

import lombok.Data;

/**
 * 
 * @ClassName DisabledEntityVO
 * @Description TODO(会员停用启用VO)
 * @author Toby
 * @Date 2019年5月13日 下午9:33:07
 * @version 1.0.0
 */
@Data
public class DisabledEntityVO {
	
	/**
	 * 会员集合
	 */
	private String uids;
	
	/**
	 * 状态
	 */
	private String isStop;
	
	/**
	 * 会员表
	 */
	private String freeUser;
}
