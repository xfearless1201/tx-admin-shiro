package com.cn.tianxia.admin.web.sys;

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

import com.cn.tianxia.admin.base.shiro.ShiroUser;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.service.txdata.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * 
 * @ClassName SysUserController
 * @Description 系统用户接口
 * @author Hardy
 * @Date 2019年4月24日 下午8:13:59
 * @version 1.0.0
 */
@Api(tags = "系统用户接口")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private Validator validator;

	/**
	 * 
	 * @Description 获取用户信息
	 * @return
	 */
	@ApiOperation(value = "查询当前登录用户信息", notes = "查询当前登录用户信息", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/info")
	public ResultResponse info() {
		try {
			ShiroUser user = getUser();
			return ResultResponse.success("获取成功", user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询当前登录用户信息异常:{}", e.getMessage());
			return ResultResponse.error("查询当前登录用户信息异常");
		}

	}

	/**
	 * 
	 * @Description 查询用户列表
	 * @param params
	 * @return
	 */
	@ApiOperation(value = "查询用户列表", notes = "查询用户列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/list")
	@RequiresPermissions("sys:user:list")
	public ResultResponse list(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
		try {
			Pager<SysUser> pager = sysUserService.list(params);
			return ResultResponse.success("查询成功", pager);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询用户列表异常:{}", e.getMessage());
			return ResultResponse.error("查询当前用户列表异常,请联系客服");
		}
	}

	/**
	 * 
	 * @Description 新增用户信息
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "新增用户信息", notes = "新增用户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/add")
	@RequiresPermissions("sys:user:add")
	public ResultResponse add(@RequestBody SysUser user) {
		try {
			// 验证请求参数
			List<ConstraintViolation> valid = validator.validate(user);
			if (!CollectionUtils.isEmpty(valid)) {
				return ResultResponse.faild(valid.get(0).getMessage());
			}
			sysUserService.save(user);
			return ResultResponse.success();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("保存用户信息异常:{}", e.getMessage());
			return ResultResponse.error("保存用户信息异常");
		}
	}

	/**
	 * 
	 * @Description 修改用户信息
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/update")
	@RequiresPermissions("sys:user:update")
	public ResultResponse update(@RequestBody SysUser user) {
		try {
			// 验证请求参数
			List<ConstraintViolation> valid = validator.validate(user);
			if (!CollectionUtils.isEmpty(valid)) {
				return ResultResponse.faild(valid.get(0).getMessage());
			}
			// 参数校验成功,开始保存用户信息
			sysUserService.save(user);
			return ResultResponse.success();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("修改用户信息异常:{}", e.getMessage());
			return ResultResponse.error("修改用户信息异常");
		}
	}

	/**
	 * 
	 * @Description 查询用户详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据ID查询用户详情", notes = "根据ID查询用户详情", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/info/{id}")
	@RequiresPermissions("sys:user:info")
	public ResultResponse info(@PathVariable(value = "id", required = true) Long id) {
		try {
			SysUser user = sysUserService.info(id);
			return ResultResponse.success("查询成功", user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("根据用户ID:{" + id + "},查询用户信息异常:{}", e.getMessage());
			return ResultResponse.error("查询用户信息异常");
		}
	}

	/**
	 * 
	 * @Description (获取代理商)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/selectTopUidName")
	// @RequiresPermissions("sys:user:selectTopUidName")
	@ApiOperation(value = "获取代理商下拉列表", notes = "获取代理商下拉列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse selectTopUidName(@RequestBody Map<String, String> params) throws Exception {

		if(!params.containsKey("cagent") || "".equals(params.get("cagent")) ){
			return ResultResponse.error("平台商为空");
		}
		try {
			SysUser user = sysUserService.selectByTopUidName(params);
			return ResultResponse.success("查询成功", user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultResponse.error("查询代理商信息异常");
		}
	}

}
