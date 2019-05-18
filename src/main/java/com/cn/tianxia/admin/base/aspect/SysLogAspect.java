package com.cn.tianxia.admin.base.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cn.tianxia.admin.base.annotation.SysLog;
import com.cn.tianxia.admin.base.shiro.ShiroUser;
import com.cn.tianxia.admin.project.txdata.SysLogInfo;
import com.cn.tianxia.admin.service.txdata.SysLogService;
import com.cn.tianxia.admin.utils.HttpContextUtils;
import com.cn.tianxia.admin.utils.IPUtils;
import com.google.gson.Gson;

/**
 * 
 * @ClassName SysLogAspect
 * @Description 系统日志，切面处理类
 * @author Hardy
 * @Date 2019年4月17日 上午10:12:42
 * @version 1.0.0
 */
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class SysLogAspect {
    
    @Autowired
    private SysLogService sysLogService;
	
	@Pointcut("@annotation(com.cn.tianxia.admin.base.annotation.SysLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		//保存日志
		saveSysLog(point, time);
		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLogInfo sysLogInfo = new SysLogInfo();
		String optContent = "";
		SysLog syslog = method.getAnnotation(SysLog.class);
		if(syslog != null){
			//注解上的描述
		    optContent = syslog.value();
		}
		
		//请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            String params = new Gson().toJson(args[0].toString());
            optContent += ":" + params;
        }catch (Exception e){

        }
		
		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLogInfo.setClazzname(className);
		sysLogInfo.setFunction(className + "." + methodName + "()");
		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//获取请求参数
		sysLogInfo.setOptContent(optContent);
		//设置IP地址
		sysLogInfo.setClientIp(IPUtils.getIpFromRequest(request));
		//用户名
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		sysLogInfo.setLoginName(user.getLoginName());//登录账号
//		sysLogInfo.setCreateTime(new Date());
//		sysLogInfo.setRoleName(user.getRoleName());
//		sysLog.setTime(time);
		//保存系统日志
		sysLogService.insertSelective(sysLogInfo);
	}
}
