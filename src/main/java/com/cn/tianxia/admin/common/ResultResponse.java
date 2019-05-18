package com.cn.tianxia.admin.common;

import com.cn.tianxia.admin.error.CommonErrorEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName ResultResponse
 * @Description 返回结果封装类
 * @author Hardy
 * @Date 2019年4月13日 下午7:08:53
 * @version 1.0.0
 */
@ApiModel(value="响应结果封装类")
public class ResultResponse {

    @ApiModelProperty(name="status",notes="status",value="响应结果状态值:0 成功 、1 失败、2 异常、3 待处理")
    private int status;
    
    @ApiModelProperty(name="code",notes="code",value="响应结果状态码:success 成功、faild 失败、error 异常、process 待处理")
    private String code;
    
    @ApiModelProperty(name="msg",notes="msg",value="响应结果描述")
    private String msg;
    
    @ApiModelProperty(name="data",notes="data",value="响应结果对象，视具体结果进行包装")
    private Object data;
    
    public ResultResponse(int status, String code, String msg) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
    }
    
    public ResultResponse(int status, String code) {
        super();
        this.status = status;
        this.code = code;
    }



    public ResultResponse(int status, String code, String msg, Object data) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public int getStatus() {
        return status;
    }

    
    public void setStatus(int status) {
        this.status = status;
    }

    
    public String getCode() {
        return code;
    }

    
    public void setCode(String code) {
        this.code = code;
    }

    
    public String getMsg() {
        return msg;
    }

    
    public void setMsg(String msg) {
        this.msg = msg;
    }

    
    public Object getData() {
        return data;
    }

    
    public void setData(Object data) {
        this.data = data;
    }
    
    public static ResultResponse success(String msg,Object data){
        return new ResultResponse(ResponseCode.SUCCESS_STATUS, ResponseCode.SUCCESS_CODE, msg, data);
    }
    
    public static ResultResponse success(){
        return new ResultResponse(ResponseCode.SUCCESS_STATUS, ResponseCode.SUCCESS_CODE);
    }
    
    public static ResultResponse faild(String msg){
        return new ResultResponse(ResponseCode.FAIL_STATUS, ResponseCode.FAIL_CODE, msg);
    }
    
    public static ResultResponse error(String msg){
        return new ResultResponse(ResponseCode.ERROR_STATUS, ResponseCode.ERROR_CODE, msg);
    }
    
    public static ResultResponse process(String msg){
        return new ResultResponse(ResponseCode.PROCESS_STATUS, ResponseCode.PROCESS_CODE, msg);
    }
    
    /**
     * 
     * @Description 令牌过期
     * @param msg
     * @param data
     * @return
     */
    public static ResultResponse expiredToken(){
        return new ResultResponse(CommonErrorEnum.TOKEN_EXPIRED.getErrCode(),ResponseCode.FAIL_CODE,CommonErrorEnum.TOKEN_EXPIRED.getErrMsg());
    }
    
    /**
     * 
     * @Description 令牌异常
     * @param msg
     * @param data
     * @return
     */
    public static ResultResponse errorToken(){
        return new ResultResponse(CommonErrorEnum.TOKEN_ERROR.getErrCode(), ResponseCode.FAIL_CODE,CommonErrorEnum.TOKEN_ERROR.getErrMsg());
    }
    
    /**
     * 
     * @Description 令牌刷新
     * @param data
     * @return
     */
    public static ResultResponse refreshToken(Object data){
        return new ResultResponse(CommonErrorEnum.TOKEN_REFRESH.getErrCode(), ResponseCode.SUCCESS_CODE,CommonErrorEnum.TOKEN_REFRESH.getErrMsg(),data);
    }
}
