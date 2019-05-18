package com.cn.tianxia.admin.service.txdata.IntegralMallService;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsType;

import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/9 18:16
 * @Description: 商品类别service
 */
public interface GoodsTypeService {
//    List<Map<String, Object>> queryPlatformInfo();

    Pager<GoodsType> queryGoodsTypeInfo(Map<String, String> params);

    Integer commodityUserId();

    Integer queryCateName(Map<String, Object> params);

    Integer commodityPid(Map<String, Object> params);

    String commodityPath(Map<String, Object> map);

    void commodityAdd(Map<String, Object> params);

    void commodityUpdate(Map<String, Object> params);

    void commodityDelete(Map<String, Object> params);
}
