package com.cn.tianxia.admin.web.plat;

import java.util.Date;
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
import com.cn.tianxia.admin.project.txdata.PlatWithdrawal;
import com.cn.tianxia.admin.service.txdata.PlatWithdrawalService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @ClassName PlatWithdrawalController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Bing
 * @Date 2019年5月3日 下午8:41:30
 * @version 1.0.0
 */
@Api(tags="存取款配置接口")
@RestController
@RequestMapping("/plat/withdrawal")
public class PlatWithdrawalController extends BaseController{

    @Autowired
    private PlatWithdrawalService platWithdrawalService;
    
    /**
     * 
     * @Description 查看存取款配置列表信息
     * @return
     */
    @ApiOperation(value = "查看存取款配置列表信息", notes = "查看存取款配置列表信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    @RequiresPermissions("plat:withdrawal:list")
    public ResultResponse list(@ApiParam(name="params",value="查询条件") @RequestParam Map<String,String> params) {
        if(!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<PlatWithdrawal> pager = platWithdrawalService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    /**
     * 
     * @Description 查看单条存取款配置信息
     * @return
     */
    @ApiOperation(value = "查看单条存取款配置信息", notes = "查看单条存取款配置信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/info/{id}")
    @RequiresPermissions("plat:withdrawal:info")
    public ResultResponse info(@ApiParam(name="id",value="查询条件")@PathVariable("id") Integer id) {
        PlatWithdrawal platWithdrawal = platWithdrawalService.info(id);
        return ResultResponse.success("查询成功", platWithdrawal);
    }
    /**
     * 
     * @Description 修改单条存取款配置信息
     * @return
     */
    @ApiOperation(value = "修改单条存取款配置信息", notes = "修改单条存取款配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    @RequiresPermissions("plat:withdrawal:update")
    public ResultResponse update(@RequestBody PlatWithdrawal platWithdrawal) {
        platWithdrawal.setUpdatetime(new Date());
        platWithdrawal.setUid(getUserId());
        int result = platWithdrawalService.update(platWithdrawal);
        if(result>0) {
            return ResultResponse.success("修改成功", result);
        }
        return ResultResponse.faild("修改失败");
    }
}
