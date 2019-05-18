package com.cn.tianxia.admin.web.IntegralMall;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.IntegralMall.OrderManage;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.OrderManageService;
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

import java.util.Date;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/14 21:21
 * @Description: 订单管理controller
 */

@Api(tags = "订单管理接口")
@RestController
@RequestMapping("/orderManage")
public class OrderManageController extends BaseController {

    @Autowired
    OrderManageService orderManageService;

    //获取平台商下拉列表数据    已有公共接口获取该下拉列表数据

    //根据参数分页查询
    @ApiOperation(value = "获取订单管理信息", notes = "获取订单管理信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/orderManageInfo")
    public ResultResponse orderManageInfo(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        //判断是否是代理账号
        if (!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<OrderManage> pager = orderManageService.queryOrderManageInfo(params);
        return ResultResponse.success("查询成功", pager);
    }


    //修改
    @ApiOperation(value = "修改订单管理信息", notes = "修改订单管理信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    public ResultResponse update(@RequestBody OrderManage orderManage) {
        try {
            orderManageService.updateByPrimaryKeySelective(orderManage);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("修改订单异常:{}", e.getMessage());
            return ResultResponse.error("修改订单异常:" + e.getMessage());
        }
    }

    //审核
    @ApiOperation(value = "审核订单信息", notes = "审核订单信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/audit")
    public ResultResponse audit(@RequestBody OrderManage orderManage) {
        OrderManage new_orderManage = orderManageService.selectByPrimaryKey(orderManage.getId());
        if (new_orderManage.getOrderState() != 0) {
            return ResultResponse.success();
        }
        orderManage.setAuditId(getUserId().intValue());//审核人
        orderManage.setAuditTime(new Date());//审核时间
        orderManage.setPluId(new_orderManage.getPluId());
        orderManage.setPluNumber(new_orderManage.getPluNumber());
        orderManage.setCid(new_orderManage.getCid());

        int flag = orderManageService.insert_auditOrder(orderManage);
        if (flag == -1) {
            return ResultResponse.error("冻结积分不足!!");
        }
        return ResultResponse.error("审核成功！");
    }

}
