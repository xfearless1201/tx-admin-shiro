package com.cn.tianxia.admin.base.shiro.filter;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.cn.tianxia.admin.base.shiro.token.JwtToken;
import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.RedisKeyConstant;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.utils.DESEncrypt;
import com.cn.tianxia.admin.utils.IPUtils;
import com.cn.tianxia.admin.utils.JsonWebTokenUtil;
import com.cn.tianxia.admin.utils.RedisUtils;
import com.cn.tianxia.admin.utils.RequestResponseUtil;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @ClassName JWTFilter
 * @Description 自定义拦截器
 * @author Hardy
 * @Date 2019年5月6日 下午8:59:49
 * @version 1.0.0
 */
public class JwtFilter extends BasicHttpAuthenticationFilter {
    
    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
    
    private final RedisUtils redisUtils;
    
    public JwtFilter(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }
    
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        //判断是否为jwt请求
        boolean isJwtRequest = (null != subject && !subject.isAuthenticated()) && isJwtSubmission(request);
        if(isJwtRequest){
            //是jwt请求
            AuthenticationToken token = createJwtToken(request);
            //进行token认证
            try {
                subject.login(token);
                //登录成功,进行授权
                return this.checkPermission(subject, mappedValue);
            } catch (AuthenticationException e) {
                //如果是JWT过期
                //用户名称
                String username = WebUtils.toHttp(request).getHeader(Constant.AUTHORIZATION_ID);
                //token令牌
                String authorization_token = WebUtils.toHttp(request).getHeader(Constant.AUTHORIZATION_TOKEN);
                //获取用户缓存信息
                @SuppressWarnings("unchecked")
                Map<String,String> usermap = redisUtils.get(RedisKeyConstant.ADMIN_USER_KEY + username,Map.class);
                if(CollectionUtils.isEmpty(usermap)){
                    //缓存被删掉了,需要重新登录
                    RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.expiredToken()),response);
                    return false;
                }
                String secret = usermap.get("secret");
                //解密header中的token
                DESEncrypt desEncrypt = new DESEncrypt(secret);
                String jwt;
                try {
                    jwt = desEncrypt.decrypt(authorization_token);
                } catch (Exception e1) {
                    // 其他的判断为JWT错误无效
                    logger.error("校验JWT秘钥是否过期时,对客服端请求头中的授权标识进行解密异常:{}",e1.getMessage());
                    RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.errorToken()),response);
                    return false;
                }
                //待刷新JWT令牌
                String refreshJwt = redisUtils.get(RedisKeyConstant.JWT_SESSION_KEY+username);
                if(StringUtils.isNotBlank(refreshJwt) && jwt.equals(refreshJwt)){
                    //重新申请新的JWT
                    //根据用户账号获取对应的权限资源
                    String roles = usermap.get("roles");
                    String perems = usermap.get("permes");
                    //seconds为单位,0.5hours
                    long refreshPeriodTime = 1800L;//半个小时
                    //设定有效期时间为1800秒,通过 >> 位移运算获取jwt的有效时间(大约在5分钟左右)
                    String newJwt = JsonWebTokenUtil.issueJWT(UUID.randomUUID().toString(),username,
                            "token-server",60L,roles,perems, SignatureAlgorithm.HS512);
                    // 将签发的JWT存储到Redis： {JWT-SESSION-{appID} , jwt}
                    //令牌加密
                    try {
                        newJwt = desEncrypt.encrypt(newJwt);
                    } catch (Exception e1) {
                        // 其他的判断为JWT错误无效
                        logger.error("校验JWT秘钥是否过期时,对客服端请求头中的授权标识进行加密异常:{}",e1.getMessage());
                        RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.errorToken()),response);
                        return false;
                    }
                    redisUtils.set(RedisKeyConstant.JWT_SESSION_KEY+username,newJwt,refreshPeriodTime);
                    RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.refreshToken(newJwt)),response);
                    return false;
                }else{
                    // jwt时间失效过期,jwt refresh time失效 返回jwt过期客户端重新登录
                    RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.expiredToken()),response);
                    return false;
                }
            }catch (Exception e) {
                // 其他错误
                RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.errorToken()),response);
                return false;
            }
        }else{
            // 请求未携带jwt 判断为无效请求
            RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.error("无效请求")),response);
            return false;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        // 未认证的情况上面已经处理  这里处理未授权
        if (subject != null && subject.isAuthenticated()){
            //  已经认证但未授权的情况
            // 告知客户端JWT没有权限访问此资源
            RequestResponseUtil.responseWrite(JSON.toJSONString(ResultResponse.error("无权访问")),servletResponse);
        }
        return false;
    }
    
    /**
     * 
     * @Description 判断是否为jwt请求
     * @param request
     * @return
     */
    private boolean isJwtSubmission(ServletRequest request){
        String authorizationToken = RequestResponseUtil.getHeader(request, Constant.AUTHORIZATION_TOKEN);
        String username = RequestResponseUtil.getHeader(request,Constant.AUTHORIZATION_ID);
        return (request instanceof HttpServletRequest)
                && !StringUtils.isEmpty(authorizationToken)
                && !StringUtils.isEmpty(username);
    }
    
    
    /**
     * 
     * @Description 创建jwt请求token
     * @param request
     * @return
     */
    private AuthenticationToken createJwtToken(ServletRequest request) {
        //获取请求头信息
        Map<String,String> headerParams = RequestResponseUtil.getRequestHeaders(request);
        String username = headerParams.get(Constant.AUTHORIZATION_ID);
        String token = headerParams.get(Constant.AUTHORIZATION_TOKEN);
        
        @SuppressWarnings("unchecked")
        Map<String,String> usermap = redisUtils.get(RedisKeyConstant.ADMIN_USER_KEY+username,Map.class);
        String jwt = "";
        if(!CollectionUtils.isEmpty(usermap)){
            //解密秘钥
            String secret = usermap.get("secret");
            DESEncrypt desEncrypt = new DESEncrypt(secret);
            try {
                jwt = desEncrypt.decrypt(token);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("创建JwtToken的时候对客服端请求头中的授权标识解密异常:{}",e.getMessage());
            }
        }
        //获取用户访问IP
        String ipHost = IPUtils.getIpFromRequest(WebUtils.toHttp(request));
        //获取访问浏览器
        String deviceInfo = WebUtils.toHttp(request).getServerName();
        //token进行解密
        return new JwtToken(username, ipHost, deviceInfo, jwt);
    }
    
    /**
     * 
     * @Description 检查用户权限
     * @param subject
     * @param mappedValue
     * @return
     */
    private boolean checkPermission(Subject subject, Object mappedValue){
        String[] perems = (String[]) mappedValue;
        return perems == null || perems.length == 0 || Stream.of(perems).anyMatch(perem -> subject.isPermitted(perem.trim()));
    }
}
