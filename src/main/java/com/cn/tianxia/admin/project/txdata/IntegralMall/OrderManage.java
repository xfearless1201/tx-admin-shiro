package com.cn.tianxia.admin.project.txdata.IntegralMall;

import lombok.Data;

import java.util.Date;

@Data
public class OrderManage {
    private Integer id;

    private Integer uid;

    private Integer cid;

    private Integer pluId;

    private Integer pluNumber;

    private Date orderTime;

    private String deliverAddress;

    private String deliverPhone;

    private String deliverName;

    private Integer deliverStatus;

    private Integer auditId;

    private Date auditTime;

    private String rmk;

    private Integer orderState;

    private String cagentName;

    private String pluName;

    private Double price;

    private String auditName;

    private String userName;

}