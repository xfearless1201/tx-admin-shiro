package com.cn.tianxia.admin.common;

/**
 * 
 * @ClassName ResponseCode
 * @Description 返回状态码接口
 * @author Hardy
 * @Date 2019年4月13日 下午7:11:19
 * @version 1.0.0
 */
public interface ResponseCode {

    static final int SUCCESS_STATUS=0; //成功状态值
   
    static final int FAIL_STATUS = 1;  //失败状态值 
    
    static final int ERROR_STATUS = 2; //异常状态值
    
    static final int PROCESS_STATUS = 3;//处理中状态值
    
    static final String SUCCESS_CODE = "success";
    
    static final String FAIL_CODE = "faild";
    
    static final String ERROR_CODE = "error";
    
    static final String PROCESS_CODE = "process";//处理中
    
}
