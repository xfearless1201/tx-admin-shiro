package com.cn.tianxia.admin.domain.txdata.IntegralMallMapper;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsType;

import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/9 18:24
 * @Description: 商品类别mapper
 */
public interface GoodsTypeMapper {
//    List<Map<String, Object>> queryPlatformInfo();

    List<GoodsType> queryGoodsTypeInfo(Pager pager);

    int queryGoodsTypeInfoCount(Pager pager);

    Integer commodityUserId();

    Integer queryCateName(Map<String, Object> params);

    Integer commodityPid(Map<String, Object> params);

    String commodityPath(Map<String, Object> map);

    void commodityAdd(Map<String, Object> params);

    void commodityUpdate(Map<String, Object> params);

    void commodityDelete(Map<String, Object> params);
}
