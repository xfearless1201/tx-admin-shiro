package com.cn.tianxia.admin.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName HttpContextUtils
 * @Description 获取request工具类
 * @author Hardy
 * @Date 2019年4月17日 上午10:09:30
 * @version 1.0.0
 */
public class HttpContextUtils {

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
