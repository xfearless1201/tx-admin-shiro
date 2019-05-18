package com.cn.tianxia.admin.common;

import lombok.Data;

import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/13 17:43
 * @Description: goods pager
 */

@Data
public class GoodsPager<T> extends Pager<T> {

    public GoodsPager() {

    }

    public GoodsPager(Map<String, String> params) {
        super(params);
    }

    private String totalSmall;
    private String pluname;
    private Integer totalNum;
    private Integer totalNumSum;
    private Integer totalFreezeNum;
    private Integer totalFreezeNumSum;
}
