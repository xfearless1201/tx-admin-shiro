package com.cn.tianxia.admin.service.txdata.IntegralMallService;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsManagement;

import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/7 17:14
 * @Description: 商品管理service
 */
public interface GoodsManagementService {

    GoodsManagement goodsManaQueryById(Map<String, String> params);

    List<GoodsManagement> goodsManaQueryAll();

    Pager<GoodsManagement> goodsManaShow(Map<String, String> params, List<GoodsManagement> updateManage);

    Integer decriptCont(Map<String, Object> params);

    Integer DescriptAdd(Map<String, Object> params);

    void descriptName(Map<String, Object> params);

    Map<String, Object> getpidName(Map<String, Object> params);

    void DescriptUpdate(Map<String, Object> params);

    List<Map<String,Object>> selectPluInventory(Map<String, Object> params);

    void DescriptDelete(Map<String, Object> params);

    void closeproxy(Map<String, Object> params);

    void openproxy(Map<String, Object> params);
}
