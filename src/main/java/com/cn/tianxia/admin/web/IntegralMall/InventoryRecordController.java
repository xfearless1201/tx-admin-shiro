package com.cn.tianxia.admin.web.IntegralMall;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsInventory;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.InventoryRecordService;
import com.cn.tianxia.admin.web.sys.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/14 18:11
 * @Description: 库存流水controller
 */

@Api(tags = "库存流水接口")
@RestController
@RequestMapping("/inventoryRecord")
public class InventoryRecordController extends BaseController {

    @Autowired
    InventoryRecordService inventoryRecordService;

    //获取平台商下拉列表数据    已有公共接口获取该下拉列表数据

    //商品类别下拉列表    暂时不用写

    //根据参数分页查询
    @ApiOperation(value = "获取商品类别信息", notes = "根据平台信息查商品类别表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/inventoryRecordInfo")
    public ResultResponse inventoryRecordInfo(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        //判断是否是代理账号
        if (!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<GoodsInventory> pager = inventoryRecordService.queryInventoryRecordInfo(params);
        return ResultResponse.success("查询成功", pager);
    }


}
