package com.cn.tianxia.admin.vo.txdata;

import lombok.Data;

/**
 * 
 * @ClassName EditUserMemberVO
 * @Description TODO(编辑会员VO)
 * @author Toby
 * @Date 2019年5月13日 下午4:51:22
 * @version 1.0.0
 */
@Data
public class EditUserMemberVO {

	/**
	 * uid
	 */
	private Integer uid;
	/**
	 * 用户姓名
	 */
	private String realname;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 取款密码
	 */
	private String qkPwd;

	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 备注
	 */
	private String rmk;
	
	/**
	 * 会员表
	 */
	private String freeUser;
}
