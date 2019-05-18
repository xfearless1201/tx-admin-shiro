package com.cn.tianxia.admin.web.sys;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.service.txdata.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * 
 * @ClassName SysRoleController
 * @Description 系统角色接口
 * @author Hardy
 * @Date 2019年4月25日 下午8:44:33
 * @version 1.0.0
 */
@Api(tags="系统角色接口")
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController{

    @Autowired
    private RoleService  roleService;
    
    @Autowired
    private Validator validator;
    
    /**
     * 
     * @Description 角色列表
     * @return
     */
    @ApiOperation(value = "查询角色列表接口", notes = "查询角色列表接口",httpMethod = "POST")
    @PostMapping("/list")
    @RequiresPermissions("sys:role:list")
    public ResultResponse list(@RequestBody Map<String,String> params){
        try {
            //如果是超级会员则可以
            if(!isAdmin()){
                //根据平台ID只能查看自己平台下面的
                params.put("cid", getCid().toString());
            }
            Pager<Role> pager = roleService.list(params);
            return ResultResponse.success("查询成功", pager);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询角色列表异常:{}",e.getMessage());
            return ResultResponse.error("查询角色列表异常");
        }
    }
    
    @ApiOperation(value = "新增角色信息接口", notes = "新增用户里信息接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    @RequiresPermissions("sys:role:add")
    public ResultResponse add(@RequestBody Role role){
        try {
            //校验请求参数
            List<ConstraintViolation> valid = validator.validate(role);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.error(valid.get(0).getMessage());
            }
            //保存用户角色信息
            roleService.save(role);
            return ResultResponse.success();
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("新增角色信息异常:{}",e.getMessage());
            return ResultResponse.error("新增角色信息异常,请联系客服");
        }
        
    }
    
    @ApiOperation(value = "更新角色信息接口", notes = "更新用户信息接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public ResultResponse update(@RequestBody Role role){
        try {
            //校验请求参数
            List<ConstraintViolation> valid = validator.validate(role);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.error(valid.get(0).getMessage());
            }
            //保存用户角色信息
            roleService.save(role);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新角色信息异常:{}",e.getMessage());
            return ResultResponse.error("更新角色信息异常");
        }
    }
    
    
    @ApiOperation(value = "删除角色信息接口", notes = "删除用户信息接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delete/{id}")
    @RequiresPermissions("sys:role:delete")
    public ResultResponse delete(@PathVariable(value="id",required=true) long id){
        try {
            roleService.delete(id);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除角色信息异常:{}",e.getMessage());
            return ResultResponse.error("删除角色信息异常");
        }
    }
    
    
    @ApiOperation(value = "查询角色详情接口", notes = "查询角色详情接口",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:role:info")
    public ResultResponse info(@PathVariable(value="id",required=true) long id){
        try {
            Role role = roleService.info(id);
            return ResultResponse.success("查询成功", role);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询角色详情异常:{}",e.getMessage());
            return ResultResponse.error("查询角色详情异常");
        }
    }
   
    
    
    @ApiOperation(value = "选择角色信息接口", notes = "选择角色信息接口",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/select")
    @RequiresPermissions("sys:role:select")
    public ResultResponse select(){
        try {
            List<Role> roles = new ArrayList<>();
            //判断是否为超级管理员
            Pager<Role> pager = new Pager<>();
            pager.setPage(null);
            pager.setLimit(null);
            Map<String,String> params = new HashMap<>();
            params.put("status", "0");
            if(!getUsername().equals(Constant.SUPER_ACCOUNT)){
                //超级管理员,查看所有的平台
                params.put("cid", getCid().toString());
            }
            pager.setParams(params);
            roles = roleService.getRoleSelectList(pager);
            return ResultResponse.success("查询成功", roles);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("选择角色信息接口异常:{}",e.getMessage());
            return ResultResponse.error("选择角色信息异常");
        }
    }
}
