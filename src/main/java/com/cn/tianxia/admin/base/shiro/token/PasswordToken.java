package com.cn.tianxia.admin.base.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ClassName PasswordToken
 * @Description 登录时使用的token
 * @author Hardy
 * @Date 2019年5月7日 下午11:37:47
 * @version 1.0.0
 */
public class PasswordToken implements AuthenticationToken {
    
    private static final long serialVersionUID = -6692175213763988623L;
    
    private String username;
    private String password;

    public PasswordToken(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Object getPrincipal() {
        return getUsername();
    }

    @Override
    public Object getCredentials() {
        return getPassword();
    }

}
