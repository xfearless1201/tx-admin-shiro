package com.cn.tianxia.admin.project.txdata;

public class PayChannel {
    private Integer id;

    private Integer typeId;

    private Integer payerId;

    private String name;

    private String code;

    private Long createTime;

    private Long updateTime;

    private Integer isDelete;

    private Boolean isSupportPc;

    private Boolean isSupportMobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getPayerId() {
        return payerId;
    }

    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean getIsSupportPc() {
        return isSupportPc;
    }

    public void setIsSupportPc(Boolean isSupportPc) {
        this.isSupportPc = isSupportPc;
    }

    public Boolean getIsSupportMobile() {
        return isSupportMobile;
    }

    public void setIsSupportMobile(Boolean isSupportMobile) {
        this.isSupportMobile = isSupportMobile;
    }
}