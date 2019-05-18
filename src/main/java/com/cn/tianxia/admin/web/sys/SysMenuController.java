package com.cn.tianxia.admin.web.sys;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.base.annotation.SysLog;
import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Resource;
import com.cn.tianxia.admin.service.txdata.ResourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName SysMenuController
 * @Description 系统菜单接口
 * @author Hardy
 * @Date 2019年4月24日 下午6:52:51
 * @version 1.0.0
 */
@Api(tags="资源(导航菜单)管理接口")
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private ResourceService resourceService;
    
    @ApiOperation(value = "查询菜单列表接口", notes = "查询菜单列表接口",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/nav")
    public ResultResponse nav(){
        try {
            List<Resource> resources = new ArrayList<>();
            if(getUsername().equals(Constant.SUPER_ACCOUNT)){
                //超级管理员
                resources = resourceService.getSysNavByUserId(null);
            }else{
                resources= resourceService.getSysNavByUserId(getUserId());
            }
            return ResultResponse.success("查询成功", resources);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询菜单列表异常:{}",e.getMessage());
            return ResultResponse.error("获取菜单异常");
        }
    }
    
    
    /**
     * 
     * @Description 获取资源列表
     * @return
     */
    @ApiOperation(value = "查询资源列表接口", notes = "查询资源列表接口",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public ResultResponse list(){
        try {
            List<Resource> resources = new ArrayList<>();
            if(getUsername().equals(Constant.SUPER_ACCOUNT)){
                //如果是超级管理员,测查看所有的资源
                resources = resourceService.findAllResources();
            }else{
                resources = resourceService.getResourcesByUserId(getUserId());
            }
            return ResultResponse.success("查询资源列表成功", resources);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询资源列表接口异常:{}",e.getMessage());
            return ResultResponse.error("查询资源列表接口异常");
        }
    }
    
    /**
     * 选择菜单(添加、修改菜单)
     */
    @ApiOperation(value = "选择菜单(添加、修改菜单)接口", notes = "选择菜单(添加、修改菜单)接口",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public ResultResponse select(){
        try {
            List<Resource> resources = new ArrayList<>();
            //添加顶级菜单
            Resource root = new Resource();
            root.setId(0L);
            root.setName("一级菜单");
            root.setPid(-1L);
            resources.add(root);
            List<Resource> list = new ArrayList<>();
            //判断是否为超级管理员
            if(getUsername().equals(Constant.SUPER_ACCOUNT)){
                //查看所有权限
                list = resourceService.findAllResources();
            }else{
                //查看自己具备的资源
                list = resourceService.getResourcesByUserId(getUserId());
            }
            resources.addAll(list);
            return ResultResponse.success("查询资源列表成功", resources);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询菜单列表异常:{}",e.getMessage());
            return ResultResponse.error("查询菜单列表异常,请联系客服");
        }
    }
    
    
    /**
     * 
     * @Description 获取菜单信息
     * @param menuId
     * @return
     */
    @ApiOperation(value = "获取(资源)菜单详情接口", notes = "获取(资源)菜单详情接口",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:menu:info")
    public ResultResponse info(@PathVariable("id") Long id){
        try {
            Resource resource = resourceService.selectByPrimaryKey(id);
            return ResultResponse.success("查询成功", resource);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("获取(资源)菜单详情异常:{}",e.getMessage());
            return ResultResponse.error("获取(资源)菜单详情异常,请联系客服");
        }
    }
    
    /**
     * 
     * @Description 修改菜单
     * @param resource
     * @return
     */
    @SysLog("修改菜单")
    @ApiOperation(value = "修改(资源)菜单接口", notes = "修改(资源)菜单接口",httpMethod = "POST")
    @PostMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public ResultResponse update(@RequestBody Resource resource){
        try {
          //校验数据
            verifyForm(resource);
            //更新资源
            resourceService.save(resource);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("更新菜单信息异常:{}",e.getMessage());
            return ResultResponse.error("更新菜单信息异常:"+e.getMessage());
        }
    }
    
    /**
     * 
     * @Description 新增
     * @param resource
     * @return
     */
    @ApiOperation(value = "新增(资源)菜单接口", notes = "新增(资源)菜单接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @SysLog("保存菜单")
    @PostMapping("/add")
    @RequiresPermissions("sys:menu:add")
    public ResultResponse save(@RequestBody Resource resource){
        try {
            //数据校验
            verifyForm(resource);
            //存入数据
            resourceService.save(resource);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("新增菜单信息异常:{}",e.getMessage());
            return ResultResponse.error("新增菜单信息异常:"+e.getMessage());
        }
    }
    
    
    /**
     * 
     * @Description 删除数据
     * @param menuId
     * @return
     */
    @ApiOperation(value = "删除(资源)菜单接口", notes = "新增(资源)菜单接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delete/{id}")
    @RequiresPermissions("sys:menu:delete")
    public ResultResponse delete(@PathVariable(value="id",required=true) Long id){
        try {
            //通过菜单ID查询菜单信息
            Resource resource = resourceService.selectByPrimaryKey(id);
            if(resource != null){
                if(resource.getIsSys() == Constant.SYS_RESOURCE){
                    return ResultResponse.error("系统菜单，不能删除");
                }
            }
            //判断是否存在子菜单
            List<Resource> subResources = resourceService.getSubResourcesByPid(resource.getId());
            if(!CollectionUtils.isEmpty(subResources)){
                return ResultResponse.error("请先删除子菜单或按钮");
            }
            resourceService.deleteByPrimaryKey(id);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除资源菜单异常:{}",e.getMessage());
            return ResultResponse.error("删除资源菜单异常,请联系客服");
        }
    }
    
    
    /**
     * 
     * @Description 禁用或开启菜单
     * @return
     */
    @ApiOperation(value = "禁用或开启(资源)菜单接口", notes = "禁用或开启(资源)菜单接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/disable/{id}/{status}")
    @RequiresPermissions("sys:menu:disable")
    public ResultResponse disableOrEnable(@RequestParam(value="id",required=true) Long id,@RequestParam(value="status",required=true)Integer status){
        try {
            resourceService.disableOrEnable(id, status);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("开启或禁用(资源)菜单接口异常:{}",e.getMessage());
            return ResultResponse.error("开启或禁用(资源)菜单接口异常");
        }
        
        
    }
    
    
    /**
     * 验证参数是否正确
     */
    private void verifyForm(Resource resource){
        if(StringUtils.isBlank(resource.getName())){
            throw new RRException("菜单名称不能为空");
        }
        
        if(resource.getPid() == null){
            throw new RRException("上级菜单不能为空");
        }
        
        //菜单
        if(resource.getType() == Constant.MenuType.MENU.getValue()){
            if(StringUtils.isBlank(resource.getNurl())){
                throw new RRException("菜单URL不能为空");
            }
        }
        
        //上级菜单类型
        int parentType = Constant.MenuType.CATALOG.getValue();
        if(resource.getPid() != 0){
            Resource parentMenu = resourceService.selectByPrimaryKey(resource.getPid());
            parentType = parentMenu.getType();
        }
        
        //目录、菜单
        if(resource.getType() == Constant.MenuType.CATALOG.getValue() ||
                resource.getType() == Constant.MenuType.MENU.getValue()){
            if(parentType != Constant.MenuType.CATALOG.getValue()){
                throw new RRException("上级菜单只能为目录类型");
            }
            return ;
        }
        
        //按钮
        if(resource.getType() == Constant.MenuType.BUTTON.getValue()){
            if(parentType != Constant.MenuType.MENU.getValue()){
                throw new RRException("上级菜单只能为菜单类型");
            }
            return ;
        }
    }
}
