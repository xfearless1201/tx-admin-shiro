package com.cn.tianxia.admin.domain.txdata.IntegralMallMapper;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsManagement;

import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/7 17:38
 * @Description: 商品管理mapper
 */
public interface GoodsManagementMapper {

    GoodsManagement catePidPath(Map<String, String> params);

    List<GoodsManagement> catePidList();

    List<GoodsManagement> selectGoodsManaByPage(Pager pager);

    int selectGoodsManaTotalCount(Pager pager);

    Integer decriptCont(Map<String, Object> params);

    Integer DescriptAdd(Map<String, Object> params);

    void descriptName(Map<String, Object> params);

    Map<String, Object> getpidName(Map<String, Object> params);

    void DescriptUpdate(Map<String, Object> params);

    List<Map<String,Object>> selectPluInventory(Map<String, Object> params);

    void DescriptDelete(Map<String, Object> params);

    void closeProxy(Map<String, Object> params);

    void openProxy(Map<String, Object> params);
}
