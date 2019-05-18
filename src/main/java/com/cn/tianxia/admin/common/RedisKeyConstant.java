package com.cn.tianxia.admin.common;

/**
 * 
 * @ClassName RedisKeyConstant
 * @Description 缓存KEY常量类
 * @author Hardy
 * @Date 2019年5月6日 下午9:46:24
 * @version 1.0.0
 */
public class RedisKeyConstant {

    /**
     * 后台用户信息缓存key
     */
    public static final String ADMIN_USER_KEY="ADMIN:USER:INFO:";
    
    /**
     * 签发的jwt令牌
     */
    public static final String JWT_SESSION_KEY="JWT-SESSION-";
}
