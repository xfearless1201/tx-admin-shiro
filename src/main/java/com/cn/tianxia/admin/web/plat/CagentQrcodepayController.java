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
import com.cn.tianxia.admin.project.txdata.CagentQrcodepay;
import com.cn.tianxia.admin.service.txdata.CagentQrcodepayService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @ClassName CagentQrcodepayController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Bing
 * @Date 2019年5月3日 下午9:30:00
 * @version 1.0.0
 */
@Api(tags="支付二维码接口")
@RestController
@RequestMapping("/plat/qrcode")
public class CagentQrcodepayController extends BaseController{

    @Autowired
    private CagentQrcodepayService cagentQrcodepayService;
    
    /**
     * 
     * @Description 查看支付二维码列表信息
     * @return
     */
    @ApiOperation(value = "查看支付二维码列表信息", notes = "查看支付二维码列表信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    @RequiresPermissions("plat:qrcode:list")
    public ResultResponse list(@ApiParam(name="params",value="查询条件") @RequestParam Map<String,String> params) {
        if(!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<CagentQrcodepay> pager = cagentQrcodepayService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    /**
     * 
     * @Description 查看单条二维码配置信息
     * @return
     */
    @ApiOperation(value = "查看单条二维码配置信息", notes = "查看单条二维码配置信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/info/{id}")
    @RequiresPermissions("plat:qrcode:info")
    public ResultResponse info(@PathVariable("id") Integer id) {
        CagentQrcodepay cagentQrcodepay = cagentQrcodepayService.info(id);
        return ResultResponse.success("查询成功", cagentQrcodepay);
    }
    /**
     * 
     * @Description 修改单条二维码配置信息
     * @return
     */
    @ApiOperation(value = "修改单条二维码配置信息", notes = "修改单条二维码配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    @RequiresPermissions("plat:qrcode:update")
    public ResultResponse update(@RequestBody CagentQrcodepay cagentQrcodepay) {
        cagentQrcodepay.setUpdatetime(new Date());
        cagentQrcodepay.setUid(getUserId());
        int result = cagentQrcodepayService.update(cagentQrcodepay);
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
    @ApiOperation(value = "添加单条二维码配置信息", notes = "添加单条二维码配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    @RequiresPermissions("plat:qrcode:add")
    public ResultResponse add(@RequestBody CagentQrcodepay cagentQrcodepay) {
        cagentQrcodepay.setUpdatetime(new Date());
        cagentQrcodepay.setUid(getUserId());
        int result = cagentQrcodepayService.add(cagentQrcodepay);
        if(result>0) {
            return ResultResponse.success("添加成功", result);
        }
        return ResultResponse.faild("添加失败");
    }
}
