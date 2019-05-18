package com.cn.tianxia.admin.po;

import java.io.Serializable;

/**
 * @ClassName SysLoginPO
 * @Description 系统登录返回封装类
 * @author Hardy
 * @Date 2019年5月7日 下午4:59:35
 * @version 1.0.0
 */
public class SysLoginPO implements Serializable {

    private static final long serialVersionUID = 2196411701920444994L;

    private String username;

    private String token;

    public SysLoginPO(String username, String token) {
        super();
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SysLoginPO [username=" + username + ", token=" + token + "]";
    }

}
