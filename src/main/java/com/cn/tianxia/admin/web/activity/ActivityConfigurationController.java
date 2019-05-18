package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.ActivityDetails;
import com.cn.tianxia.admin.service.txdata.ActivityDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:32
 * @Description: 活动配置controller
 */
//@Api(tags = "活动配置接口")
//@RestController
//@RequestMapping("/activity/config")
@Slf4j
public class ActivityConfigurationController {
    @Autowired
    private ActivityDetailsService activityDetailsService;

    //活动配置查询
    @ApiOperation(value = "活动配置", notes = "活动配置查询", httpMethod = "POST")
    @PostMapping("/list")
    public ResultResponse activityList(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        Pager<ActivityDetails> pager = activityDetailsService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
