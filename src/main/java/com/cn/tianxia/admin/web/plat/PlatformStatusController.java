package com.cn.tianxia.admin.web.plat;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.PlatformStatus;
import com.cn.tianxia.admin.service.txdata.PlatformStatusService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @ClassName CagentGameController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Bing
 * @Date 2019年5月7日 下午3:12:26
 * @version 1.0.0
 */
@Api(tags="游戏平台状态接口")
@RestController
@RequestMapping("/plat/game")
public class PlatformStatusController extends BaseController{

    @Autowired
    private PlatformStatusService platformStatusService;
    
    /**
     * 
     * @Description 查看游戏平台状态列表信息
     * @return
     */
    @ApiOperation(value = "查看游戏平台状态列表信息", notes = "查看游戏平台状态列表信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    @RequiresPermissions("plat:game:list")
    public ResultResponse list(@ApiParam(name="params",value="查询条件") @RequestParam Map<String,String> params) {
        if(!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<PlatformStatus> pager = platformStatusService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    /**
     * 
     * @Description 查看单条游戏平台状态信息
     * @return
     */
    @ApiOperation(value = "查看单条游戏平台状态信息", notes = "查看单条游戏平台状态信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/info/{id}")
    @RequiresPermissions("plat:game:info")
    public ResultResponse info(@ApiParam(name="id",value="查询条件")@PathVariable("id") Integer id) {
        PlatformStatus platformStatus = platformStatusService.info(id);
        return ResultResponse.success("查询成功", platformStatus);
    }
    /**
     * 
     * @Description 修改单条游戏平台状态信息
     * @return
     */
    @ApiOperation(value = "修改单条游戏平台状态信息", notes = "修改单条游戏平台状态信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    @RequiresPermissions("plat:game:update")
    public ResultResponse update(@RequestBody PlatformStatus platformStatus) {
        int result = platformStatusService.update(platformStatus);
        if(result>0) {
            return ResultResponse.success("修改成功", result);
        }
        return ResultResponse.faild("修改失败");
    }
}
