package com.cn.tianxia.admin.game.enums;

/**
 * @Author: zed
 * @Date: 2019/5/10 10:52
 * @Description: 转账结果枚举
 */
public enum TransferResultEnum {
    SUCCESS("success","转账成功"),
    FAILED("failed", "转账失败"),
    PROCESS("process", "转账处理中")
    ;

    private String status;
    private String message;

    TransferResultEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
