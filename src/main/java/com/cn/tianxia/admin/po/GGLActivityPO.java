package com.cn.tianxia.admin.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: zed
 * @Date: 2019/4/28 19:42
 * @Description: 刮刮乐活动PO
 */
@Data
public class GGLActivityPO implements Serializable {

    private static final long serialVersionUID = 8973333414128851474L;

    private Long id;
    private String cagent;
    private Integer cid;
    private String name;
    private Integer status;
    private Long createTime;
    private Long updateTime;
    private Double minquota;
    private Double maxquota;
    private Double userMoney;
    private Integer type;
    private String createName;
    private String updateName;
    private String description;

}
