package com.cn.tianxia.admin.base.shiro;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName ShiroUser
 * @Description 认真用户信息
 * @author Hardy
 * @Date 2019年4月24日 下午2:31:06
 * @version 1.0.0
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -8401918752041209440L;

    private Long id;

    private Integer cid;

    private Integer type;

    private String username;

    private String name;

    private String roleName;

    private Long rid;

    private Set<String> urls;

    private Set<String> roles;

    private Byte userType;

    private String cagent;

    private String secret;

    public ShiroUser() {
        super();
    }

    public ShiroUser(Long id, Integer cid, Integer type, String username, String name, String roleName, Long rid,
            Set<String> urls, Set<String> roles, Byte userType, String cagent, String secret) {
        super();
        this.id = id;
        this.cid = cid;
        this.type = type;
        this.username = username;
        this.name = name;
        this.roleName = roleName;
        this.rid = rid;
        this.urls = urls;
        this.roles = roles;
        this.userType = userType;
        this.cagent = cagent;
        this.secret = secret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public String getCagent() {
        return cagent;
    }

    public void setCagent(String cagent) {
        this.cagent = cagent;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

}
