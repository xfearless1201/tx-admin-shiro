package com.cn.tianxia.admin.service.txdata.IntegralMallService.IntegralMallServiceImpl;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.IntegralMallMapper.GoodsTypeMapper;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsType;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/9 18:21
 * @Description: 商品类别serviceImpl
 */
@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    /*@Override
    public List<Map<String, Object>> queryPlatformInfo() {
        return goodsTypeMapper.queryPlatformInfo();
    }*/

    @Override
    public Pager<GoodsType> queryGoodsTypeInfo(Map<String, String> params) {
        Pager<GoodsType> pager = new Pager<>(params);
        List<GoodsType> list = goodsTypeMapper.queryGoodsTypeInfo(pager);
        int count = goodsTypeMapper.queryGoodsTypeInfoCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

    @Override
    public Integer commodityUserId() {
        return goodsTypeMapper.commodityUserId();
    }

    @Override
    public Integer queryCateName(Map<String, Object> params) {
        return goodsTypeMapper.queryCateName(params);
    }

    @Override
    public Integer commodityPid(Map<String, Object> params) {
        return goodsTypeMapper.commodityPid(params);
    }

    @Override
    public String commodityPath(Map<String, Object> map) {
        return goodsTypeMapper.commodityPath(map);
    }

    @Override
    public void commodityAdd(Map<String, Object> params) {
        goodsTypeMapper.commodityAdd(params);
    }

    @Override
    public void commodityUpdate(Map<String, Object> params) {
        goodsTypeMapper.commodityUpdate(params);
    }

    @Override
    public void commodityDelete(Map<String, Object> params) {
        goodsTypeMapper.commodityDelete(params);
    }

}
