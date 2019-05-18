package com.cn.tianxia.admin.vo.txdata;

import lombok.Data;

/**
 * 
 * @ClassName AddUserMemberVO
 * @Description TODO(平台会员添加)
 * @author Toby
 * @Date 2019年5月9日 下午4:22:07
 * @version 1.0.0
 */
@Data
public class AddUserMemberVO {

	/**
	 * uid
	 */
	private Integer uid;
	/**
	 * 代理ID
	 */
	private Integer topUid;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 用户姓名
	 */
	private String realname; 	
	
	/**
	 * 游戏用户名
	 */
	private String agUsername;
	
	/**
	 * 进入游戏密码
	 */
	private String agPassword;
	
	/**
	 * 皇冠用户名
	 */
	private String hgUsername;
	/**
	 * 取款密码
	 */
	private String qkPwd;
	
	/**
	 * vip级别 （预留）
	 */
	private Integer vipLevel;
	
	/**
	 * 登录IP
	 */
	private String loginIp;
	
	/**
	 * 注册IP
	 */
	private String regIp; 
	
	/**
	 * 平台商
	 */
	private String cagent;
	
	/**
	 * 会员分层ID
	 */
	private Integer typeId;
	
	/**
	 * 注册类型
	 */
	private String mobile;
	
	/**
	 * 二级代理ID
	 */
	private String juniorUid;
}
	
