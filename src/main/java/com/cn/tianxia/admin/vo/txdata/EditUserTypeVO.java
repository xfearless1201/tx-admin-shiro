package com.cn.tianxia.admin.vo.txdata;

import lombok.Data;

/**
 * 
 * @ClassName EditUserTypeVO
 * @Description TODO(修改会员层级)
 * @author Toby
 * @Date 2019年5月17日 下午1:55:42
 * @version 1.0.0
 */
@Data
public class EditUserTypeVO {

	/**
	 * 会员ID
	 */
	private String uids;
	
	/**
	 * 会员层级
	 */
	private Integer typeid;
}
