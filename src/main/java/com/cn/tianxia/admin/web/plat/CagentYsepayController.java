package com.cn.tianxia.admin.web.plat;

import java.util.Date;
import java.util.HashMap;
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
import com.cn.tianxia.admin.project.txdata.CagentQrcodepay;
import com.cn.tianxia.admin.project.txdata.CagentYsepay;
import com.cn.tianxia.admin.service.txdata.CagentQrcodepayService;
import com.cn.tianxia.admin.service.txdata.CagentYsepayService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @ClassName CagentYsepayController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Bing
 * @Date 2019年5月6日 下午4:41:20
 * @version 1.0.0
 */
@Api(tags="在线支付配置接口")
@RestController
@RequestMapping("/plat/ysepay")
public class CagentYsepayController extends BaseController{

    @Autowired
    private CagentYsepayService cagentYsepayService;
    
    /**
     * 
     * @Description 查看在线支付配置列表信息
     * @return
     */
    @ApiOperation(value = "查看在线支付配置列表信息", notes = "查看在线支付配置列表信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    @RequiresPermissions("plat:ysepay:list")
    public ResultResponse list(@ApiParam(name="params",value="查询条件") @RequestParam Map<String,String> params) {
        if(!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<CagentYsepay> pager = cagentYsepayService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    /**
     * 
     * @Description 查看单条在线支付配置信息
     * @return
     */
    @ApiOperation(value = "查看单条在线支付配置信息", notes = "查看单条在线支付配置信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/info/{id}")
    @RequiresPermissions("plat:ysepay:info")
    public ResultResponse info(@PathVariable("id") Integer id) {
        CagentYsepay cagentYsepay = cagentYsepayService.info(id);
        return ResultResponse.success("查询成功", cagentYsepay);
    }
    /**
     * 
     * @Description 修改在线支付配置信息
     * @return
     */
    @ApiOperation(value = "修改在线支付配置信息", notes = "修改在线支付配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    @RequiresPermissions("plat:ysepay:update")
    public ResultResponse update(@RequestBody CagentYsepay cagentYsepay) {
        cagentYsepay.setUpdatetime(new Date());
        cagentYsepay.setUid(getUserId());
        int result = cagentYsepayService.update(cagentYsepay);
        if(result>0) {
            return ResultResponse.success("修改成功", result);
        }
        return ResultResponse.faild("修改失败");
    }
    /**
     * 
     * @Description 添加单条二维码配置信息
     * @return
     */
    @ApiOperation(value = "添加在线支付配置信息", notes = "添加在线支付配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    @RequiresPermissions("plat:ysepay:add")
    public ResultResponse add(@RequestBody CagentYsepay cagentYsepay) {
        cagentYsepay.setUpdatetime(new Date());
        cagentYsepay.setUid(getUserId());
        int result = cagentYsepayService.add(cagentYsepay);
        if(result>0) {
            return ResultResponse.success("添加成功", result);
        }
        return ResultResponse.faild("添加失败");
    }
    /**
     * 
     * @Description 删除单条二维码配置信息
     * @return
     */
    @ApiOperation(value = "删除在线支付配置信息", notes = "删除在线支付配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delete/{id}")
    @RequiresPermissions("plat:ysepay:delete")
    public ResultResponse delete(@PathVariable("id") Integer id) {
        int result = cagentYsepayService.delete(id);
        if(result>0) {
            return ResultResponse.success("删除成功", result);
        }
        return ResultResponse.faild("删除失败");
    }
}
