package com.cn.tianxia.admin.web.activity;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.po.GGLActivityPO;
import com.cn.tianxia.admin.service.txdata.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:37
 * @Description: 刮刮乐活动配置controller
 */
@Api(tags = "刮刮乐接口")
@RestController
@RequestMapping("/activity/guagua")
@Slf4j
public class GuaGuaConfigurationController {

    @Autowired
    ActivityService activityService;

    //    @ApiOperation(value = "刮刮乐", notes = "刮刮乐查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "刮刮乐", notes = "刮刮乐查询", httpMethod = "POST")
    @PostMapping("/list")
    public ResultResponse guaGuaActivityManager(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        Pager<GGLActivityPO> pager = activityService.gglList(params);
        return ResultResponse.success("查询成功", pager);
    }
}
