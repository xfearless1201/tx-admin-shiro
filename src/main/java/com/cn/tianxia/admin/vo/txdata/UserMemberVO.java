package com.cn.tianxia.admin.vo.txdata;

/**
 * 
 * @ClassName UserMemberVO
 * @Description TODO(平台会员VO类)
 * @author Toby
 * @Date 2019年4月29日 下午7:17:35
 * @version 1.0.0
 */
public class UserMemberVO {

	/**
	 * 代理商
	 */
	private String topUidName;
	
	/**
	 * 开始时间(注册)
	 */
	private String startTime;
	
	/**
	 * 结束时间(注册)
	 */
	private String endTime;
	
	/**
	 * 会员账号
	 */
	private String username;
	
	
	/**
	 * 用户姓名
	 */
	private String realname;
	
	
	/**
	 * 登录IP
	 */
	private String loginIp;
	
	/**
	 * 注册IP
	 */
	private String regIp;
	
	/**
	 * 余额大于
	 */
	private Double wallet;
	
	/**
	 * 打码量大于
	 */
	private String quantity;
	
	/**
	 * 输赢大于
	 */
	private Double winAmountGT;
	
	/**
	 * 输赢小于
	 */
	private Double winAmountLT;
	
	/**
	 * 分层
	 */
	private String userTypeName;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 注册域名
	 */
	private String regurl;
	
	/**
	 * 银行卡
	 */
	private String bankCard;
	
	/**
	 * 开户人
	 */
	private String cardUsername;
	
	/**
	 * 用户状态
	 */
	private String isStop;
	
	/**
	 * 平台商
	 */
	private String cagent;

	public String getTopUidName() {
		return topUidName;
	}

	public void setTopUidName(String topUidName) {
		this.topUidName = topUidName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getWinAmountGT() {
		return winAmountGT;
	}

	public void setWinAmountGT(Double winAmountGT) {
		this.winAmountGT = winAmountGT;
	}

	public Double getWinAmountLT() {
		return winAmountLT;
	}

	public void setWinAmountLT(Double winAmountLT) {
		this.winAmountLT = winAmountLT;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRegurl() {
		return regurl;
	}

	public void setRegurl(String regurl) {
		this.regurl = regurl;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getCardUsername() {
		return cardUsername;
	}

	public void setCardUsername(String cardUsername) {
		this.cardUsername = cardUsername;
	}

	public String getIsStop() {
		return isStop;
	}

	public void setIsStop(String isStop) {
		this.isStop = isStop;
	}

	public String getCagent() {
		return cagent;
	}

	public void setCagent(String cagent) {
		this.cagent = cagent;
	}
}
