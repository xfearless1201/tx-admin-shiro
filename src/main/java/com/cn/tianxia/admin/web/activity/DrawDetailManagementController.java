package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.LotteryRecord;
import com.cn.tianxia.admin.service.txdata.LotteryRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:40
 * @Description: 抽奖明细管理controller
 */
//@Api(tags = "抽奖明细管理接口")
//@RestController
//@RequestMapping("/activity/detail")
@Slf4j
public class DrawDetailManagementController {
    @Autowired
    private LotteryRecordService lotteryRecordService;

    //抽奖明细管理查询
    @ApiOperation(value = "抽奖明细管理", notes = "抽奖明细管理查询", httpMethod = "POST")
    @PostMapping("/list")
    public ResultResponse lotteryRecord(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        Pager<LotteryRecord> pager;
        //0-抽奖明细 1-中奖明细
        if ("0".equals(params.get("is_lottery"))) {
            pager = lotteryRecordService.luckyDrawList(params);
        } else {
            pager = lotteryRecordService.winningList(params);
        }
        return ResultResponse.success("查询成功", pager);
    }
}
