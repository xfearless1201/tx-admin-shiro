package com.cn.tianxia.admin.web.cagent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.service.txdata.CagentService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * 
 * @ClassName CagentController
 * @Description 平台商接口
 * @author Hardy
 * @Date 2019年4月28日 上午11:08:33
 * @version 1.0.0
 */
@Api(tags="平台商管理接口")
@RestController
@RequestMapping("/cagent")
public class CagentController extends BaseController{
    
    @Autowired
    private CagentService cagentService;

    @Autowired
    private Validator validator;
    
    /**
     * 
     * @Description 查看平台商列表信息
     * @return
     */
    @ApiOperation(value = "查询平台商列表接口", notes = "查询平台商列表接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/list")
    @RequiresPermissions("cagent:list")
    public ResultResponse list(@RequestBody Map<String,String> params){
        try {
            Pager<Cagent> pager = cagentService.list(params);
            return ResultResponse.success("查询成功", pager);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询平台商列表异常:{}",e.getMessage());
            return ResultResponse.error("查询平台商列表异常");
        }
    }
    
    /**
     * 
     * @Description 平台选择树
     * @return
     */
    @ApiOperation(value = "选择平台商列表接口", notes = "选择平台商列表接口",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/select")
    @RequiresPermissions("cagent:select")
    public ResultResponse select(){
        try {
            List<Cagent> cagents = new ArrayList<>();
            if(isAdmin()){
                //查询全平台
                cagents = cagentService.getCagentSelectList(null);
            }else{
                cagents = cagentService.getCagentSelectList(getCid());
            }
            return ResultResponse.success("选择平台商列表成功", cagents);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("选择平台商列表异常:{}",e.getMessage());
            return ResultResponse.error("选择平台商列表异常");
        }
    }
    
    @ApiOperation(value = "新增平台商信息接口", notes = "新增平台商信息接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    @RequiresPermissions("cagent:add")
    public ResultResponse add(@RequestBody Cagent cagent){
        try {
            //验证请求参数
            List<ConstraintViolation> valid = validator.validate(cagent);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.faild(valid.get(0).getMessage());
            }
            //保存平台信息
            cagentService.save(cagent);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增平台商信息异常:{}",e.getMessage());
            return ResultResponse.error("新增平台商信息异常,请联系客服");
        }
    }
    
    @ApiOperation(value = "更新平台商信息接口", notes = "更新平台商信息接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    @RequiresPermissions("cagent:update")
    public ResultResponse update(@RequestBody Cagent cagent){
        try {
            //验证请求参数
            List<ConstraintViolation> valid = validator.validate(cagent);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.faild(valid.get(0).getMessage());
            }
            //保存平台信息
            cagentService.save(cagent);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新平台商信息异常:{}",e.getMessage());
            return ResultResponse.error("更新平台商信息异常,请联系客服");
        }
    }
    
    @ApiOperation(value = "删除平台商信息接口", notes = "删除平台商信息接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delete/{id}")
    @RequiresPermissions("cagent:delete")
    public ResultResponse delete(@PathVariable(value="id",required=true) int id){
        try {
            cagentService.deleteByPrimaryKey(id);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除平台商信息异常:{}",e.getMessage());
            return ResultResponse.error("删除平台商信息异常");
        }
    }
    
    @ApiOperation(value = "修改平台商状态接口", notes = "修改平台商状态接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/disable/{id}/{status}")
    @RequiresPermissions("cagent:delete")
    public ResultResponse disableOrEnable(@PathVariable(value="id",required=true) int id,
                                            @PathVariable(value="status",required=true) int status){
        try {
            cagentService.disableOrEnable(id, status);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("禁用或启用平台异常:{}",e.getMessage());
            return ResultResponse.error(e.getMessage());
        }
    }
}
