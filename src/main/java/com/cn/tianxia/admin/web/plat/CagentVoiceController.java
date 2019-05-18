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
import com.cn.tianxia.admin.project.txdata.CagentVoice;
import com.cn.tianxia.admin.service.txdata.CagentVoiceService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @ClassName CagentVoiceController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Bing
 * @Date 2019年5月7日 上午11:11:20
 * @version 1.0.0
 */
@Api(tags="平台声音管理接口")
@RestController
@RequestMapping("/plat/voice")
public class CagentVoiceController extends BaseController{

    @Autowired
    private CagentVoiceService cagentVoiceService;
    
    /**
     * 
     * @Description 查看平台声音列表信息
     * @return
     */
    @ApiOperation(value = "查看平台声音列表信息", notes = "查看平台声音列表信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    @RequiresPermissions("plat:voice:list")
    public ResultResponse list(@ApiParam(name="params",value="查询条件") @RequestParam Map<String,String> params) {
        if(!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<CagentVoice> pager = cagentVoiceService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    /**
     * 
     * @Description 查看单条声音配置信息
     * @return
     */
    @ApiOperation(value = "查看单条声音配置信息", notes = "查看单条声音配置信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/info/{id}")
    @RequiresPermissions("plat:voice:info")
    public ResultResponse info(@PathVariable("id") Integer id) {
        CagentVoice cagentVoice = cagentVoiceService.info(id);
        return ResultResponse.success("查询成功", cagentVoice);
    }
    /**
     * 
     * @Description 修改单条声音配置信息
     * @return
     */
    @ApiOperation(value = "修改单条声音配置信息", notes = "修改单条声音配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    @RequiresPermissions("plat:voice:update")
    public ResultResponse update(@RequestBody CagentVoice cagentVoice) {
        int result = cagentVoiceService.update(cagentVoice);
        if(result>0) {
            return ResultResponse.success("修改成功", result);
        }
        return ResultResponse.faild("修改失败");
    }
    /**
     * 
     * @Description 添加单条声音配置信息
     * @return
     */
    @ApiOperation(value = "添加单条声音配置信息", notes = "添加单条声音配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    @RequiresPermissions("plat:voice:add")
    public ResultResponse add(@RequestBody CagentVoice cagentVoice) {
        int result = cagentVoiceService.add(cagentVoice);
        if(result>0) {
            return ResultResponse.success("添加成功", result);
        }
        return ResultResponse.faild("添加失败");
    }
    /**
     * 
     * @Description 删除单条声音配置信息
     * @return
     */
    @ApiOperation(value = "删除单条声音配置信息", notes = "删除单条声音配置信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delete/{id}")
    @RequiresPermissions("plat:voice:delete")
    public ResultResponse delete(@PathVariable("id") Integer id) {
        int result = cagentVoiceService.delete(id);
        if(result>0) {
            return ResultResponse.success("删除成功", result);
        }
        return ResultResponse.faild("删除失败");
    }
}
