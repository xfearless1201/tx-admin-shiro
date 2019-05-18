package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @ClassName UserMemberTs
 * @Description TODO(会员返水)
 * @author Toby
 * @Date 2019年5月17日 下午3:14:17
 * @version 1.0.0
 */
@Data
public class UserMemberTs {
    
	/**
	 * ID
	 */
	private Integer id;
	
	/**
	 * 用户UID
	 */
	private Integer uid;
	
	/**
	 * 平台ID
	 */
	private Integer cid;
	
	/**
	 * 游戏平台编码
	 */
	private String gametype;
	
	/**
	 * 游戏平台名字
	 */
	private String gameTypeName;
	
	/**
	 * 注单条目数
	 */
	private Integer noteNum;
	
	/**
	 * 投注额
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
	 * 退水金额
	 */
	private Double tsAmount;
	
	/**
	 * 修改时间
	 */
	private Date updatetime;
	
	/**
	 * 返水时间
	 */
	private Date backtime;
	
}