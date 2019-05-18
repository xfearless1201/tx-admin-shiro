package com.cn.tianxia.admin.base.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ClassName JWTToken
 * @Description 自定义校验规则
 * @author Hardy
 * @Date 2019年5月6日 下午9:26:14
 * @version 1.0.0
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = -8596826585488926645L;

    /**
     * 用户的标识
     */
    private String username;
    /**
     * 用户的IP
     */
    private String ipHost;
    /**
     * 设备信息
     */
    private String deviceInfo;
    /**
     * json web token值
     */
    private String jwt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpHost() {
        return ipHost;
    }

    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public JwtToken(String username, String ipHost, String deviceInfo, String jwt) {
        super();
        this.username = username;
        this.ipHost = ipHost;
        this.deviceInfo = deviceInfo;
        this.jwt = jwt;
    }

    @Override
    public Object getPrincipal() {
        return getUsername();
    }

    @Override
    public Object getCredentials() {
        return getJwt();
    }

}
