package com.cn.tianxia.admin.web.IntegralMall;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.GoodsInventoryService;
import com.cn.tianxia.admin.web.sys.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/12 17:38
 * @Description: 商品库存controller
 */

@Api(tags = "商品库存接口")
@RestController
@RequestMapping("/goodsInventoryController")
public class GoodsInventoryController extends BaseController {

    @Autowired
    GoodsInventoryService goodsInventoryService;

    //获取平台商下拉列表数据    已有公共接口获取该下拉列表数据

    //商品类别下拉列表    暂时不用写

    //根据参数分页查询
    @ApiOperation(value = "获取商品类别信息", notes = "根据平台信息查商品类别表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/goodsInventoryInfo")
    public ResultResponse goodsInventoryInfo(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        //判断是否是代理账号
        if (!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<GoodsInventory> pager = goodsInventoryService.queryGoodsInventoryInfo(params);
        return ResultResponse.success("查询成功", pager);
    }


    //入库    出库  冻结  解冻
    @ApiOperation(value = "入库 出库 冻结 解冻", notes = "修改库存数量", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/updatePluInv")
    public ResultResponse updatePluInv(@RequestParam Map<String, Object> params) {
        //判断是否是代理账号
        if (!isAdmin()) {
            params.put("cid", getCid());
        }
        //获取用户id
        params.put("upuid", getUserId());
        //根据参数修改t_plu_inventory单条数据
        int updatePluInv = goodsInventoryService.updatePluInv(params);

        //往t_plu_inventory_log添加日志信息
        int updatePluInvLog = goodsInventoryService.updatePluInvLog(params);

        if (updatePluInv + updatePluInvLog == 2) {
            return ResultResponse.success();
        } else {
            return ResultResponse.faild("入库失败或未成功添加日志记录");
        }
    }
}
