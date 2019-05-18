package com.cn.tianxia.admin.web.IntegralMall;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.UserWalletLog;
import com.cn.tianxia.admin.service.txdata.UserWalletLogService;
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
 * @Date: 2019/5/16 11:00
 * @Description: 会员钱包controller
 */

@Api(tags = "会员钱包/会员钱包变动接口")
@RestController
@RequestMapping("/userWallet")
public class UserWalletController extends BaseController {

    @Autowired
    UserWalletLogService userWalletLogService;

    //获取平台商下拉列表数据    已有公共接口获取该下拉列表数据

    //根据参数分页查询    会员钱包查询和会员钱包变动查询访问的是同一个接口
    @ApiOperation(value = "获取会员钱包和变动信息", notes = "获取会员钱包和变动信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/userWalletInfo")
    public ResultResponse userWalletInfo(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        if (!isAdmin()) {
            if (getType() == 0) {
                params.put("cid", getCid().toString());

            } else {
                params.put("top_uid", Long.toString(getUserId()));
            }
        }
        Pager<UserWalletLog> pager = userWalletLogService.selectDataGrid(params);
        return ResultResponse.success("查询成功", pager);
    }
}
