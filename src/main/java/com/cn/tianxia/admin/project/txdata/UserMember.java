package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

public class UserMember {
	
	/**
	 * 会员UID
	 */
    private Integer uid;

    /**
     * 会员密码
     */
    private String password;

    /**
     * 会员名
     */
    private String username;

    /**
     * 会员姓名
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
     * 第三方游戏名
     */
    private String agUsername;

    /**
     * 第三方游戏密码
     */
    private String agPassword;

    /**
     * 皇冠游戏名
     */
    private String hgUsername;

    /**
     * MG游戏名
     */
    private String mgUsername;

    /**
     * 邮箱
     */
    private String email;

    /**
     * vip等级（预留字段）
     */
    private String vipLevel;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 平台商
     */
    private String cagent;

    private String isDaili;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 取款密码
     */
    private String qkPwd;

    /**
     * 注册时间
     */
    private Date regDate;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 金额
     */
    private Double wallet;

    /**
     * 代理ID
     */
    private Integer topUid;

    /**
     * 是否启用 0启用；1停用
     */
    private String isStop;

    /**
     * 注册方式  0 PC;1 手机;2 APP;3 IOS; 4 Android; 99 手工注册
     */
    private String isMobile;

    /**
     * 备注
     */
    private String rmk;

    /**
     * 会员层级ID
     */
    private Integer typeId;

    /**
     * 二级代理
     */
    private Integer juniorUid;

    /**
     * 注册来源
     */
    private String regurl;

    /**
     * 认证手机号
     */
    private String loginmobile;

    /**
     * 会员输赢
     */
    private Double userWinAmount;
   
    /**
     * 打码量
     */
    private Double userQuantity;
    
    /**
     * 会员层级
     */
    private String typeName;
    
    /**
     * 代理商
     */
    private String topUidName;
    
    /**
     * 要求打码量
     */
    private Double markingQuantity;
    
    /**
     * 打码量ID
     */
    private Integer quantityId;
    
    /**
     * 会员积分
     */
    private Double integral;
    
    /**
     * 开户人姓名
     */
    private String cradUsername;
    
    /**
     * 银行ID
     */
    private Integer bankId;
    
    /**
     * 银行名称
     */
    private String bankName;
    
    /**
     * 开户行
     */
    private String cardAddress;
    
    /**
     * 银行卡
     */
    private String cardNum;
    
    
    public String getCradUsername() {
		return cradUsername;
	}

	public void setCradUsername(String cradUsername) {
		this.cradUsername = cradUsername;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardAddress() {
		return cardAddress;
	}

	public void setCardAddress(String cardAddress) {
		this.cardAddress = cardAddress;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Double getUserWinAmount() {
		return userWinAmount;
	}

	public void setUserWinAmount(Double userWinAmount) {
		this.userWinAmount = userWinAmount;
	}

	public Double getUserQuantity() {
		return userQuantity;
	}

	public void setUserQuantity(Double userQuantity) {
		this.userQuantity = userQuantity;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTopUidName() {
		return topUidName;
	}

	public void setTopUidName(String topUidName) {
		this.topUidName = topUidName;
	}

	public Double getMarkingQuantity() {
		return markingQuantity;
	}

	public void setMarkingQuantity(Double markingQuantity) {
		this.markingQuantity = markingQuantity;
	}

	public Integer getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(Integer quantityId) {
		this.quantityId = quantityId;
	}

	public Double getIntegral() {
		return integral;
	}

	public void setIntegral(Double integral) {
		this.integral = integral;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    public String getAgUsername() {
        return agUsername;
    }

    public void setAgUsername(String agUsername) {
        this.agUsername = agUsername == null ? null : agUsername.trim();
    }

    public String getAgPassword() {
        return agPassword;
    }

    public void setAgPassword(String agPassword) {
        this.agPassword = agPassword == null ? null : agPassword.trim();
    }

    public String getHgUsername() {
        return hgUsername;
    }

    public void setHgUsername(String hgUsername) {
        this.hgUsername = hgUsername == null ? null : hgUsername.trim();
    }

    public String getMgUsername() {
        return mgUsername;
    }

    public void setMgUsername(String mgUsername) {
        this.mgUsername = mgUsername == null ? null : mgUsername.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel == null ? null : vipLevel.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent == null ? null : cagent.trim();
    }

    public String getIsDaili() {
        return isDaili;
    }

    public void setIsDaili(String isDaili) {
        this.isDaili = isDaili == null ? null : isDaili.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getQkPwd() {
        return qkPwd;
    }

    public void setQkPwd(String qkPwd) {
        this.qkPwd = qkPwd == null ? null : qkPwd.trim();
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

    public Integer getTopUid() {
        return topUid;
    }

    public void setTopUid(Integer topUid) {
        this.topUid = topUid;
    }

    public String getIsStop() {
        return isStop;
    }

    public void setIsStop(String isStop) {
        this.isStop = isStop == null ? null : isStop.trim();
    }

    public String getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(String isMobile) {
        this.isMobile = isMobile == null ? null : isMobile.trim();
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getJuniorUid() {
        return juniorUid;
    }

    public void setJuniorUid(Integer juniorUid) {
        this.juniorUid = juniorUid;
    }

    public String getRegurl() {
        return regurl;
    }

    public void setRegurl(String regurl) {
        this.regurl = regurl == null ? null : regurl.trim();
    }

    public String getLoginmobile() {
        return loginmobile;
    }

    public void setLoginmobile(String loginmobile) {
        this.loginmobile = loginmobile == null ? null : loginmobile.trim();
    }
}