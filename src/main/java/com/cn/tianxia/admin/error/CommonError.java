package com.cn.tianxia.admin.error;

/**
 * @Author: zed
 * @Date: 2019/5/5 16:44
 * @Description: 通用错误接口
 */
public interface CommonError {
    int getErrCode();

    String getErrMsg();

    CommonError setErrMsg(String errMsg);
}
