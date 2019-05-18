package com.cn.tianxia.admin.service.txdata.IntegralMallService.IntegralMallServiceImpl;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.IntegralMallMapper.GoodsManagementMapper;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsManagement;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.GoodsManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/7 17:18
 * @Description: 商品管理serviceImpl
 */

@Service
public class GoodsManagementServiceImpl implements GoodsManagementService {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(GoodsManagementServiceImpl.class);

    @Autowired
    GoodsManagementMapper goodsManagementMapper;

    @Override
    public GoodsManagement goodsManaQueryById(Map<String, String> params) {
        return goodsManagementMapper.catePidPath(params);
    }

    @Override
    public List<GoodsManagement> goodsManaQueryAll() {
        return goodsManagementMapper.catePidList();
    }

    @Override
    public Pager<GoodsManagement> goodsManaShow(Map<String, String> params, List<GoodsManagement> updateManage) {
        Pager<GoodsManagement> pager = new Pager<>(params);
        pager.setList(updateManage);
        List<GoodsManagement> list = goodsManagementMapper.selectGoodsManaByPage(pager);
        int count = goodsManagementMapper.selectGoodsManaTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

    @Override
    public Integer decriptCont(Map<String, Object> params) {
        return goodsManagementMapper.decriptCont(params);
    }

    @Override
    public Integer DescriptAdd(Map<String, Object> params) {
        return goodsManagementMapper.DescriptAdd(params);
    }

    @Override
    public void descriptName(Map<String, Object> params) {
        goodsManagementMapper.descriptName(params);
    }

    @Override
    public Map<String, Object> getpidName(Map<String, Object> params) {
        return goodsManagementMapper.getpidName(params);
    }

    @Override
    public void DescriptUpdate(Map<String, Object> params) {
        goodsManagementMapper.DescriptUpdate(params);
    }

    @Override
    public List<Map<String, Object>> selectPluInventory(Map<String, Object> params) {
        return goodsManagementMapper.selectPluInventory(params);
    }

    @Override
    public void DescriptDelete(Map<String, Object> params) {
        goodsManagementMapper.DescriptDelete(params);
    }

    @Override
    public void closeproxy(Map<String, Object> params) {
        goodsManagementMapper.closeProxy(params);
    }

    @Override
    public void openproxy(Map<String, Object> params) {
        goodsManagementMapper.openProxy(params);
    }
}
