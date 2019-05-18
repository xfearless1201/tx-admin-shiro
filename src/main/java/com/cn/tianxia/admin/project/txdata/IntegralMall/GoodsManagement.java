package com.cn.tianxia.admin.project.txdata.IntegralMall;
import lombok.Data;
import java.util.Date;
/**
 * @Author: hulk
 * @Date: 2019/5/7 20:20
 * @Description: 商品管理所有字段
 */
@Data
public class GoodsManagement {
    //t_plu_cate表字段
    private int id;//主键
    private int cid;//平台ID
    private int pid;//上级ID
    private String catename;//类别名称
    private String path;//路径
    private Date uptime;//更新时间
    private int upuid;//更新人
    private String rmk;//备注

    private int cateid;//类别ID
    private String pluname;//商品名
    private String icon;//缩略图地址
    private Double cprice;//价值(参考值)
    private Double oprice;//原价(参考值)
    private Double price;//积分兑换价
    private char status;//状态 0 正常,1 停用
    private String describe;//商品描述
    private int type;//商品类型 0为虚拟物品1为实物
    private String sketch;//商品简述
    private int seq;//排序
}
