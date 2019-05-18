package com.cn.tianxia.admin.project.txdata;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotEmpty;

@ApiModel(value="系统用户实体类")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 576546946380627488L;

    @ApiModelProperty(name="id",notes="id",value="用户ID")
    private Long id;
    
    @NotEmpty(message = "登录账号不能为空")
    @ApiModelProperty(name="loginName",notes="loginName",value="用户登录账号",required=true)
    private String loginName;

    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(name="name",notes="name",value="用户名",required=true)
    private String name;

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(name="password",notes="password",value="用户登录密码",required=true)
    private String password;

    private String salt;

    @ApiModelProperty(name="sex",notes="sex",value="用户性别 0 女 1 男",required=true)
    private Byte sex;

    @ApiModelProperty(name="age",notes="age",value="用户年龄",required=true)
    private Byte age;

    @NotEmpty(message = "手机号码不能为空")
    @ApiModelProperty(name="phone",notes="phone",value="手机号码",required=true)
    private String phone;

    @ApiModelProperty(name="userType",notes="userType",value="用户类型",required=true)
    private Byte userType;

    @ApiModelProperty(name="status",notes="status",value="账号状态",required=true)
    private Byte status;

    private Integer organizationId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(name="cid",notes="cid",value="平台ID",required=true)
    private Integer cid;//平台ID

    @ApiModelProperty(name="type",notes="type",value="代理商类型 0 平台  1 一级代理 2 二级代理",required=true)
    private Integer type;

    private Integer loginstatus;

    private String loginDomain;
    
    //登录用户的代理商信息
    private Cagent cagent;

    @ApiModelProperty(name="roleId",notes="roleId",value="角色ID",required=true)
    private Long roleId;//角色ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(Integer loginstatus) {
        this.loginstatus = loginstatus;
    }

    public String getLoginDomain() {
        return loginDomain;
    }

    public void setLoginDomain(String loginDomain) {
        this.loginDomain = loginDomain == null ? null : loginDomain.trim();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Cagent getCagent() {
        return cagent;
    }

    public void setCagent(Cagent cagent) {
        this.cagent = cagent;
    }

}
