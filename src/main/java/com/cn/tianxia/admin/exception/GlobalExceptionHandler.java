package com.cn.tianxia.admin.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.error.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: zed
 * @Date: 2019/5/5 21:03
 * @Description: 全局异常处理器
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultResponse handlerException(Exception ex) {
        log.error("Exception :" + ex);
        return ResultResponse.error(ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultResponse handlerException(BusinessException ex) {
        log.error("BusinessException :" + ex);
        return ResultResponse.error(ex.getErrMsg());
    }
    
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultResponse unauthorizedException(UnauthorizedException ex) {
        log.error("UnauthorizedException :" + ex);
        return ResultResponse.error("无权访问");
    }
}
