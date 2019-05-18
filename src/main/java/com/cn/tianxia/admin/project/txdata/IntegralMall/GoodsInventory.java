package com.cn.tianxia.admin.project.txdata.IntegralMall;

import lombok.Data;

import java.util.Date;

/**
 * @Author: hulk
 * @Date: 2019/5/13 16:28
 * @Description: 商品库存实体类
 */

@Data
public class GoodsInventory {

    private int id;//主键
    private int cid;//平台ID
    private int pluid;
    private String orderno;
    private int num;
    private String type;
    private String tType;//1:入库 ,2:出库 ,3:发货,4:冻结 ,5:解冻,6:积分兑换
    private Date uptime;//更新时间
    private int upuid;//更新人
    private String pluname;//商品名
    private String cagent;//代理号(用于区分网站会员)
    private String catename;//类别名称
    private String loginName;//登陆名
    private int freezeNum;//冻结库存

//    private String totalSmall;
//    private Integer totalNum;
//    private Integer totalNumSum;
//    private Integer totalFreezeNum;
//    private Integer totalFreezeNumSum;
}
