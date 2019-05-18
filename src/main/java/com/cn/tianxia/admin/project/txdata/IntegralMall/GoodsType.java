package com.cn.tianxia.admin.project.txdata.IntegralMall;

import lombok.Data;

import java.util.Date;

/**
 * @Author: hulk
 * @Date: 2019/5/7 20:20
 * @Description: 商品类型所有字段
 */
@Data
public class GoodsType {
    //t_plu_cate表字段
    private int id;//主键
    private int cid;//平台ID
    private int pid;//上级ID
    private String catename;//类别名称
    private String path;//路径
    private Date uptime;//更新时间
    private int upuid;//更新人
    private String rmk;//备注
}
