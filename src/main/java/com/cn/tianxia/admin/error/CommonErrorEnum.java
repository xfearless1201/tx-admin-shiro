package com.cn.tianxia.admin.error;

/**
 * @Author: zed
 * @Date: 2019/5/5 16:49
 * @Description: 异常错误类枚举
 */
public enum CommonErrorEnum implements CommonError{

    // 通用错误类型
    PARAMMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOW_ERROR(10002,"未知异常"),

    WALLET_BALANCE_NOT_SUFFICIENT(30002, "用户钱包余额不足"),
    GAME_BALANCE_NOT_SUFFICIENT(30003, "游戏账户余额不足"),
    PLATFORM_IN_MAINTENANCE(30004, "游戏平台维护中"),
    CAGENT_GAME_CLOSED(30005, "代理平台游戏关闭"),
    CREATE_OR_CHECK_ACCOUNT_FAIL(30006, "检查或创建用户失败"),
    INSERT_TRANSFER_RECORD_FAIL(30007, "插入资金流水异常"),
    CREATE_TRANSFER_ORDER_FAIL(30008, "生成转账订单号异常"),
    GAME_CONFIG_IS_EMPTY(30009, "游戏配置为空"),
    GAME_TRANSFER_ERROR(30010,"游戏转账失败"),

    
    TOKEN_EXPIRED(40000,"令牌过期"),
    TOKEN_REFRESH(40002,"令牌已刷新"),
    TOKEN_ERROR(40001,"令牌校验异常"),
    
    USERMEMBER_USERTYPE_ERROR(50001,"获取会员分层异常"),
    USERMEMBER_INTEGRAL_ERROR(50002,"获取会员积分比例异常"),
    USERMEMBER_CAGENTID_ERROR(50003,"获取平台商信息异常"),
    USERMEMBER_USERNAME_ERROR(50004,"用户名不存在"),
    USERMEMBER_CAGENTSTORED_ERROR(50005,"获取平台商额度异常"),
    USERMEMBER_AMOUNT_ERROR(50006,"单笔金额不得超过20万"),
    USERMEMBER_CONFIGURATION_ERROR(50007,"获取存取款配置异常"),
    USERMEMBER_DEDUCTION_ERROR(50008,"扣款金额不能超过用户当前钱包余额"),
    USERMEMBER_CONFIRMTS_ERROR(50009,"无返水数据"),
    USERMEMBER_REMAINVALUE_ERROR(50010,"获取额度异常"),
    USERMEMBER_INSUFFICIENT_ERROR(50011,"平台额度不足"),
    
    ;


    CommonErrorEnum(int errCode,String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    @Override
    public String toString() {
        return "CommonErrorEnum{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
