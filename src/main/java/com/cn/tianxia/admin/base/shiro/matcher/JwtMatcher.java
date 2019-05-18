package com.cn.tianxia.admin.base.shiro.matcher;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

import com.cn.tianxia.admin.base.shiro.JwtAccount;
import com.cn.tianxia.admin.utils.JsonWebTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * 
 * @ClassName JWTMatcher
 * @Description 重写jwt比较器
 * @author Hardy
 * @Date 2019年5月6日 下午9:57:41
 * @version 1.0.0
 */
public class JwtMatcher implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String jwt = (String) authenticationInfo.getCredentials();
        JwtAccount jwtAccount = null;
        try{
            jwtAccount = JsonWebTokenUtil.parseJwt(jwt,JsonWebTokenUtil.SECRET_KEY);
        } catch(SignatureException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e){
            // 令牌错误
            throw new AuthenticationException("errJwt");
        } catch(ExpiredJwtException e){
            // 令牌过期
            throw new AuthenticationException("expiredJwt");
        } catch(Exception e){
            throw new AuthenticationException("errJwt");
        }
        if(null == jwtAccount){
            throw new AuthenticationException("errJwt");
        }
        return true;
    }
}
