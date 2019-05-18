package com.cn.tianxia.admin.project.txdata;

import java.util.Date;

import net.sf.oval.constraint.NotEmpty;

/**
 * 
 * @ClassName Organization
 * @Description 部门组织机构表实体类
 * @author Hardy
 * @Date 2019年5月4日 下午3:03:21
 * @version 1.0.0
 */
public class Organization {
    private Long id;

    @NotEmpty(message="组织名称不能为空")
    private String name;

    @NotEmpty(message="组织地址不能为空")
    private String address;

    @NotEmpty(message="组织编号不能为空")
    private String code;

    private String icon;

    private Long pid;

    private Byte seq;

    private Date createTime;

    @NotEmpty(message="组织所属平台ID不能为空")
    private Long cid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Byte getSeq() {
        return seq;
    }

    public void setSeq(Byte seq) {
        this.seq = seq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}