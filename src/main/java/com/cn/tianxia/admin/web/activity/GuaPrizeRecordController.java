package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.UserAcitivityRecord;
import com.cn.tianxia.admin.service.txdata.UserAcitivityRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:36
 * @Description: 刮奖记录
 */
@Api(tags = "刮奖记录接口")
@RestController
@RequestMapping("/activity/guagua")
@Slf4j
public class GuaPrizeRecordController {
    @Autowired
    private UserAcitivityRecordService userAcitivityRecordService;

    //刮奖记录查询
    @ApiOperation(value = "刮奖记录", notes = "刮奖记录查询", httpMethod = "POST")
    @PostMapping("/record")
    public ResultResponse guaRecordList(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        Pager<UserAcitivityRecord> pager = userAcitivityRecordService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
