package com.cn.tianxia.admin.base.shiro.filter;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.cn.tianxia.admin.base.shiro.token.PasswordToken;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.utils.RedisUtils;
import com.cn.tianxia.admin.utils.RequestResponseUtil;

import io.jsonwebtoken.lang.Collections;

/**
 * @ClassName ShiroFilter
 * @Description 重写过滤器,拦截所有的请求
 * @author Hardy
 * @Date 2019年5月7日 下午8:12:51
 * @version 1.0.0
 */
public class PasswordFilter extends BasicHttpAuthenticationFilter {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(PasswordFilter.class);

    private RedisUtils redisUtils;// 缓存工具

    public PasswordFilter(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    /**
     * 重写是否被容许访问函数,true则继续访问
     */

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        // 判断用户是否已登录,如果已登录就拒绝统一交给onAccessDenied处理
        Subject subject = getSubject(request, response);
        return null != subject && subject.isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
     // 判断是否是登录请求
        if(isLoginPost(request, response)){
            AuthenticationToken authenticationToken = createPasswordToken(request);
            Subject subject = getSubject(request,response);
            try {
                subject.login(authenticationToken);
                //登录认证成功,进入请求派发json web token url资源内
                return true;
            }catch (AuthenticationException e) {
                logger.error(authenticationToken.getPrincipal()+"::"+e.getMessage());
                // 返回response告诉客户端认证失败
                RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.faild("登录失败")),response);
                return false;
            }catch (Exception e) {
                logger.error(authenticationToken.getPrincipal()+"::认证异常::"+e.getMessage(),e);
                // 返回response告诉客户端认证失败
                RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.faild("登录失败")),response);
                return false;
            }
        }
        // 请求未携带jwt 判断为无效请求
        RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.error("无效请求")), response);
        return false;
    }

    /**
     * 是否为登录请求
     */
    private boolean isLoginPost(ServletRequest request, ServletResponse response) throws Exception{
     // 判断客服端的请求是否为登录请求,判断标准请求域名包含login,请求体参数有username,password,captcha
        Map<String, String> params = RequestResponseUtil.getRequestBodyMap(request);
        if (Collections.isEmpty(params)) {
            return false;
        }
        String method = WebUtils.toHttp(request).getRequestURI();
        return (request instanceof HttpServletRequest)
                && "POST".equals(((HttpServletRequest) request).getMethod().toUpperCase())
                && null != params.get("password") && null != params.get("username")
                // && null != params.get("captcha")
                && method.endsWith("sys/login");
    }
    
    /**
     * 
     * @Description 创建登录token
     * @param request
     * @return
     * @throws Exception
     */
    private AuthenticationToken createPasswordToken(ServletRequest request) throws Exception {
        //获取请求body中的参数
        Map<String ,String> map = RequestResponseUtil.getRequestBodyMap(request);
        String username = map.get("username");
        String password = map.get("password");
        return new PasswordToken(username, password);
    }


}
