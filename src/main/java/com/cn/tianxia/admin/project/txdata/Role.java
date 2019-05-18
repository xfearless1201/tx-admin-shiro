package com.cn.tianxia.admin.project.txdata;

import java.io.Serializable;
import java.util.List;

import net.sf.oval.constraint.NotEmpty;

public class Role implements Serializable {

    private static final long serialVersionUID = -7086534409404580521L;

    private Long id;

    @NotEmpty(message="角色名称不能为空")
    private String name;

    private Byte seq;

    private String description;

    @NotEmpty(message="角色状态不能为空")
    private Byte status;

    private Integer cid;
    
    private List<Long> menuIdList;

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

    public Byte getSeq() {
        return seq;
    }

    public void setSeq(Byte seq) {
        this.seq = seq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

}
