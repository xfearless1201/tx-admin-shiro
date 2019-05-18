package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.CagentLuckyDraw;
import com.cn.tianxia.admin.service.txdata.CagentLuckyDrawService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:26
 * @Description: 红包活动配置controller
 */
@Api(tags = "红包活动配置接口")
@RestController
@RequestMapping("/activity/redpacket")
@Slf4j
public class RedPacketConfigurationController {

    @Autowired
    private CagentLuckyDrawService cagentLuckyDrawService;

    //红包活动配置查询
    @ApiOperation(value = "红包活动配置", notes = "红包活动配置查询", httpMethod = "POST")
    @PostMapping("/list")
    public ResultResponse configList(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        Pager<CagentLuckyDraw> pager = cagentLuckyDrawService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
