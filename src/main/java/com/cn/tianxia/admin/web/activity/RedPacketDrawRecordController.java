package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.UserLuckrdrawLog;
import com.cn.tianxia.admin.service.txdata.UserLuckrdrawLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:28
 * @Description: 红包抽奖记录controller
 */
@Api(tags = "红包抽奖记录接口")
@RestController
@RequestMapping("/activity/redpacket")
@Slf4j
public class RedPacketDrawRecordController {

    @Autowired
    UserLuckrdrawLogService userLuckrdrawLogService;

    //红包抽奖记录查询
    @ApiOperation(value = "红包抽奖记录", notes = "红包抽奖记录查询", httpMethod = "POST")
    @PostMapping("/record")
//    @RequiresPermissions("activity:redpacket:record")
    public ResultResponse drawRecord(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        Pager<UserLuckrdrawLog> pager = userLuckrdrawLogService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
