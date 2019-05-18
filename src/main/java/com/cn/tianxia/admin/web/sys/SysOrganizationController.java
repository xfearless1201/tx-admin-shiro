package com.cn.tianxia.admin.web.sys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.Organization;
import com.cn.tianxia.admin.service.txdata.OrganizationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * 
 * @ClassName SysOrganizationController
 * @Description 系统部门组织机构接口
 * @author Hardy
 * @Date 2019年5月4日 下午2:37:19
 * @version 1.0.0
 */
@Api(tags="系统部门组织机构接口")
@RestController
@RequestMapping("sys/organization")
public class SysOrganizationController extends BaseController{

    @Autowired
    private OrganizationService organizationService;
    
    @Autowired
    private Validator validator;
    
    @ApiOperation(value = "查询系统部门组织机构列表接口", notes = "查询系统部门组织机构列表接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/list")
    public ResultResponse list(@RequestBody Map<String,String> params){
        try {
            if(!isAdmin()){
                //用户
                params.put("cid", getCid().toString());
            }
            Pager<Organization> pager = organizationService.list(params);
            return ResultResponse.success("查询系统部门组织机构列表成功",pager);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询系统部门组织机构列表异常:{}",e.getMessage());
            return ResultResponse.error("查询系统部门组织机构列表异常");
        }
    }
    
    @ApiOperation(value = "新增系统部门组织机构列表接口", notes = "新增系统部门组织机构列表接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    public ResultResponse add(@RequestBody Organization organization){
        try {
            //验证请求参数
            List<ConstraintViolation> valid = validator.validate(organization);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.faild(valid.get(0).getMessage());
            }
            organizationService.save(organization);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增系统部门组织机构列表异常:{}",e.getMessage());
            return ResultResponse.error("新增系统部门组织机构列表异常");
        }
    }
    
    @ApiOperation(value = "修改系统部门组织机构列表接口", notes = "修改系统部门组织机构列表接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    public ResultResponse update(@RequestBody Organization organization){
        try {
            //验证请求参数
            List<ConstraintViolation> valid = validator.validate(organization);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.faild(valid.get(0).getMessage());
            }
            organizationService.save(organization);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增系统部门组织机构列表异常:{}",e.getMessage());
            return ResultResponse.error("新增系统部门组织机构列表异常");
        }
    }
    
    @ApiOperation(value = "删除系统部门组织机构列表接口", notes = "删除系统部门组织机构列表接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delete")
    public ResultResponse delete(@PathVariable(value="id",required=true) long id){
        try {
            organizationService.deleteByPrimaryKey(id);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除系统部门组织机构列表异常:{}",e.getMessage());
            return ResultResponse.error("删除系统部门组织机构列表异常");
        }
    }
}
