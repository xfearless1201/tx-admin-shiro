package com.cn.tianxia.admin.web.member;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.project.txdata.UserLogin;
import com.cn.tianxia.admin.project.txdata.UserMember;
import com.cn.tianxia.admin.project.txdata.UserMemberTs;
import com.cn.tianxia.admin.project.txdata.UserPlatformReport;
import com.cn.tianxia.admin.project.txdata.UserType;
import com.cn.tianxia.admin.project.txdata.WinDetails;
import com.cn.tianxia.admin.service.txdata.InternalMessageService;
import com.cn.tianxia.admin.service.txdata.UserLoginService;
import com.cn.tianxia.admin.service.txdata.UserMemberService;
import com.cn.tianxia.admin.service.txdata.UserPlatformReportService;
import com.cn.tianxia.admin.service.txdata.UserTypeService;
import com.cn.tianxia.admin.utils.DESEncrypt;
import com.cn.tianxia.admin.utils.IPUtils;
import com.cn.tianxia.admin.vo.txdata.UserMoneyVO;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName MemberController
 * @Description TODO(平台会员管理)
 * @author Toby
 * @Date 2019年4月27日 下午9:05:31
 * @version 1.0.0
 */

@Api(tags = "平台会员接口")
@RestController
@RequestMapping("/member/user")
public class UserMemberController extends BaseController {

	/**
	 * 平台会员
	 */
	@Autowired
	private UserMemberService userMemberService;

	/**
	 * 会员注单汇总
	 */
	@Autowired
	private UserPlatformReportService userPlatformReportService;

	/**
	 * 会员登录记录
	 */
	@Autowired
	private UserLoginService userLoginService;

	/**
	 * 会员分层
	 */
	@Autowired
	private UserTypeService userTypeService;

	/**
	 * 站内信
	 */
	@Autowired
	private InternalMessageService internalMessageService;

	/**
	 * 
	 * @Description (平台会员查询)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	// @RequiresPermissions("member:user:list")
	@ApiOperation(value = "查询会员列表", notes = "查询会员列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse memberInquery(@RequestBody Map<String, String> params) throws Exception {

		try {
			// 判断不是管理员获取平台商ID
			if (!isAdmin()) {
				if (getCid() == 0) {
					// 根据平台ID只能查看自己平台下面的
					params.put("cid", getCid().toString());
				}
			}
			Pager<UserMember> pager = userMemberService.memberInquiry(params);
			return ResultResponse.success("查询成功", pager);
		} catch (Exception e) {
			logger.error("查询平台会员异常:{}", e.getMessage());
			return ResultResponse.error("查询平台会员异常");
		}
	}

	/**
	 * 
	 * @Description ((打码量)根据UID查询会员注单统计)
	 * @param uid
	 * @return
	 */
	@PostMapping("/selectByUid")
	// @RequiresPermissions("member:user:selectByUid")
	@ApiOperation(value = "打码量", notes = "打码量", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse selectByUid(Integer uid) throws Exception {

		if (uid == null) {
			return ResultResponse.error("UID不能为空");
		}

		try {
			Pager<UserPlatformReport> pager = userPlatformReportService.selectByUid(uid);
			return ResultResponse.success("查询成功", pager);
		} catch (Exception e) {
			logger.error("查询会员注单统计异常:{}", e.getMessage());
			return ResultResponse.error("查询会员注单统计异常");
		}
	}

	/**
	 * 
	 * @Description (查询会员登录记录)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/selectUserLoginByUid")
	// @RequiresPermissions("member:user:selectUserLoginByUid")
	@ApiOperation(value = "登录记录", notes = "登录记录", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse selectUserLoginByUid(@RequestBody Map<String, String> params) throws Exception {

		if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
			return ResultResponse.error("UID不能为空");
		}
		try {
			Pager<UserLogin> pager = userLoginService.selectUserLoginByUid(params);
			return ResultResponse.success("查询成功", pager);
		} catch (Exception e) {
			logger.error("查询会员登录记录:{}", e.getMessage());
			return ResultResponse.error("查询会员登录记录异常");
		}
	}

	/**
	 * 
	 * @Description (输赢详情)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/selectWinDetails")
	// @RequiresPermissions("member:user:selectWinDetails")
	@ApiOperation(value = "输赢详情", notes = "输赢详情", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse selectWinDetails(@RequestBody Map<String, String> params) throws Exception {

		if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
			return ResultResponse.error("UID不能为空");
		}
		if (!params.containsKey("startTime") || "".equals(params.get("startTime"))) {
			return ResultResponse.error("开始时间不能为空");
		}
		if (!params.containsKey("endTime") || "".equals(params.get("endTime"))) {
			return ResultResponse.error("结束时间不能为空");
		}
		if (!params.containsKey("page") && params.get("page") == null) {
			return ResultResponse.error("分页参数异常");
		}
		if (!params.containsKey("limit") && params.get("limit") == null) {
			return ResultResponse.error("分页参数异常");
		}
		try {
			Pager<WinDetails> pager = userMemberService.selectWinDetails(params);
			return ResultResponse.success("查询成功", pager);
		} catch (Exception e) {
			logger.error("查询会员输赢详情:{}", e.getMessage());
			return ResultResponse.error("查询会员登录记录异常");
		}
	}

	/**
	 * 
	 * @Description (查询会员输赢详情明细)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/selectWinDetailsPage")
	// @RequiresPermissions("member:user:selectWinDetailsPage")
	@ApiOperation(value = "输赢详情", notes = "输赢详情明细", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse selectWinDetailsPage(@RequestBody Map<String, String> params) throws Exception {

		if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
			return ResultResponse.error("UID不能为空");
		}
		if (!params.containsKey("betTime") || "".equals(params.get("betTime"))) {
			return ResultResponse.error("时间不能为空");
		}
		try {
			Pager<WinDetails> pager = userMemberService.selectWinDetailsPage(params);
			return ResultResponse.success("查询成功", pager);
		} catch (Exception e) {
			logger.error("查询会员输赢详情:{}", e.getMessage());
			return ResultResponse.error("查询会员登录记录异常");
		}
	}

	/**
	 * 
	 * @Description (添加会员)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/addUserMember")
	// @RequiresPermissions("member:user:addUserMember")
	@ApiOperation(value = "添加会员", notes = "添加会员", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse addUserMember(@RequestBody Map<String, String> params, HttpServletRequest request)
			throws Exception {

		try {
			if (!params.containsKey("password") || "".equals(params.get("password"))) {
				return ResultResponse.error("会员密码为空");
			}
			if (!params.containsKey("username") || "".equals(params.get("username"))) {
				return ResultResponse.error("会员账号");
			}
			if (!params.containsKey("qkpwd") || "".equals(params.get("qkpwd"))) {
				return ResultResponse.error("取款密码为空");
			}
			if (!params.containsKey("realname") || "".equals(params.get("realname"))) {
				return ResultResponse.error("用户姓名为空");
			}
			if (!params.containsKey("mobile") || "".equals(params.get("mobile"))) {
				return ResultResponse.error("手机号码为空");
			}
			if (!params.containsKey("cagent") || "".equals(params.get("cagent"))) {
				return ResultResponse.error("平台商为空");
			}
			/**
			 * 判断是否为管理员，是平台商查询出所属平台默认分层 是代理查询出所属平台
			 */
			if (!isAdmin()) {
				if (getType() == 1) {
					params.put("topUid", getUserId() + "");
				} else if (getType() == 2) {
					// 查询出当前2级代理的所属上级
				}
				params.put("typeid", userTypeService.queryDefault(getUser().getCid()) + "");
			}

			/**
			 * 生成agpassword
			 */
			StringBuilder str = new StringBuilder();
			str.append(getUsername());
			Random randoms = new Random();
			// 随机生成数字，并添加到字符串
			int max = 999999;
			int min = 100000;
			int ss = randoms.nextInt(max) % (max - min + 1) + min;
			str.append(ss);
			String agpwd = str.toString();
			// 保证10位长度
			if (agpwd.length() > 10) {
				agpwd = agpwd.substring(0, 10);
			}
			params.put("agpassword", agpwd);
			params.put("loginIp", IPUtils.getIpFromRequest(request));
			params.put("regIp", IPUtils.getIpFromRequest(request));

			int addUserMemberCount = userMemberService.addUserMember(params);

			if (addUserMemberCount == -1) {
				return ResultResponse.error("该用户名为系统预留账号，不能注册！");
			}
			if (addUserMemberCount == -2) {
				return ResultResponse.error("用户名已存在，请重新输入！");
			}
			if (addUserMemberCount == -3) {
				return ResultResponse.error("(历史用户)用户名已存在，请重新输入！");
			}
			return ResultResponse.success();
		} catch (Exception e) {
			logger.error("添加会员异常:{}", e.getMessage());
			return ResultResponse.error("添加会员异常");
		}
	}

	/**
	 * 
	 * @Description (编辑会员也，查看会员页)
	 * @param params
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/editPage")
	// @RequiresPermissions("member:user:editPage")
	@ApiOperation(value = "编辑会员", notes = "编辑会员查询数据", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse editPage(@RequestBody Map<String, String> params) throws Exception {
		try {
			if (!params.containsKey("uid") && !"".equals(params.get("uid"))) {
				return ResultResponse.error("UID为空");
			}
			UserMember userMember = userMemberService.editPage(params);
			return ResultResponse.success("查询成功", userMember);
		} catch (Exception e) {
			logger.error("根据UID查询会员数据异常:{}", e.getMessage());
			return ResultResponse.error("根据UID查询会员数据异常");
		}
	}

	/**
	 * 
	 * @Description (编辑会员)
	 * @param platformUserFormMap
	 * @param params
	 * @param request
	 * @return
	 */
	@PostMapping("/editUserMember")
	// @RequiresPermissions("member:user:editUserMember")
	@ApiOperation(value = "编辑会员", notes = "编辑会员", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse editUserMember(@RequestBody Map<String, String> params, HttpServletRequest request)
			throws Exception {

		try {

			if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
				return ResultResponse.error("UID为空");
			}
			if (!params.containsKey("realname") || "".equals(params.get("realname"))) {
				return ResultResponse.error("用户姓名为空");
			}
			if (!params.containsKey("mobile") || "".equals(params.get("mobile"))) {
				return ResultResponse.error("手机号为空");
			}
			if (!params.containsKey("markingQuantity") || "".equals(params.get("markingQuantity"))) {
				return ResultResponse.error("要求打码量为空");
			}
			if (params.containsKey("qkPwd") && !"".equals(params.get("qkPwd"))) {
				DESEncrypt d = new DESEncrypt("tianxia88");
				try {
					params.put("qkPwd", d.encrypt(params.get("qkPwd")));
				} catch (Exception e) {
					logger.error("会员取款加密异常:{}", e.getMessage());
				}
			}
			if (params.containsKey("password") && !"".equals(params.get("password"))) {
				DESEncrypt d = new DESEncrypt("tianxia88");
				try {
					params.put("password", d.encrypt(params.get("password")));
				} catch (Exception e) {
					logger.error("会员密码加密异常:{}", e.getMessage());
				}
			}
			if (params.containsKey("cradUsername") && !"".equals(params.get("cradUsername"))) {
				if (!params.containsKey("bankId") || "".equals(params.get("bankId"))) {
					return ResultResponse.error("bankId(银行名称ID异常)");
				}
			}

			int editUserMemberCount = userMemberService.editUserMember(params);
			if (editUserMemberCount == 1) {
				return ResultResponse.success();
			} else {
				return ResultResponse.error("编辑会员数据异常");
			}
		} catch (Exception e) {
			logger.error("编辑会员数据异常:{}", e.getMessage());
			return ResultResponse.error("编辑会员数据异常");
		}
	}

	/**
	 * 
	 * @Description (会员停用启用)
	 * @param params
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/disabledEntity")
	// @RequiresPermissions("member:user:editUserMember")
	@ApiOperation(value = "停用/启用", notes = "停用/启用", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse disabledEntity(@RequestBody Map<String, String> params, HttpServletRequest request)
			throws Exception {

		try {
			if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
				return ResultResponse.error("UID为空");
			}
			if (!params.containsKey("isStop") || "".equals(params.get("isStop"))) {
				return ResultResponse.error("状态为空");
			}
			userMemberService.disabledEntity(params);
			return ResultResponse.success();
		} catch (Exception e) {
			logger.error("根据UID查询会员数据异常:{}", e.getMessage());
			return ResultResponse.error("根据UID查询会员数据异常");
		}

	}

	/**
	 * 
	 * @Description (手动加款页)
	 * @param params
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/additionPage")
	// @RequiresPermissions("member:user:additionPage")
	@ApiOperation(value = "手动加款", notes = "手动加款页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse additionPage(@RequestBody Map<String, String> params, HttpServletRequest request)
			throws Exception {

		if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
			return ResultResponse.error("UID为空");
		}
		if (!params.containsKey("cagent") || "".equals(params.get("cagent"))) {
			return ResultResponse.error("平台商为空");
		}
		UserMoneyVO userMoney = userMemberService.additionPage(params);
		return ResultResponse.success("查询成功", userMoney);
	}

	/**
	 * 
	 * @Description (手动加款/手动扣款/赠送彩金)
	 * @param params
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/addAmount")
	// @RequiresPermissions("member:user:addAmount")
	@ApiOperation(value = "手动加款/手动扣款/赠送彩金", notes = "手动加款/手动扣款/赠送彩金", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse addAmount(@RequestBody Map<String, String> params, HttpServletRequest request)
			throws Exception {

		if (!params.containsKey("amount") || "".equals(params.get("amount"))) {
			return ResultResponse.error("金额为空");
		}
		if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
			return ResultResponse.error("UID为空");
		}
		if (!params.containsKey("cagent") || "".equals(params.get("cagent"))) {
			return ResultResponse.error("平台商为空");
		}
		if (!params.containsKey("recordType") || "".equals(params.get("recordType"))) {
			return ResultResponse.error("类型为空");
		}

		if (params.containsKey("recordType") && "1".equals(params.get("recordType"))) {
			if (!params.containsKey("isOffer") || "".equals(params.get("isOffer"))) {
				return ResultResponse.error("存款赠送优惠为空");
			}
			if (!params.containsKey("isCJ") || "".equals(params.get("isCJ"))) {
				return ResultResponse.error("存款赠送彩金为空");
			}
			if (!params.containsKey("isIntegral") || "".equals(params.get("isIntegral"))) {
				return ResultResponse.error("存款计算积分为空");
			}
			if (!params.containsKey("isDml") || "".equals(params.get("isDml"))) {
				return ResultResponse.error("存款计算打码量为空");
			}
			if (!params.containsKey("isClearDML") || "".equals(params.get("isClearDML"))) {
				return ResultResponse.error("是否清空历史打码量为空");
			}
		} else if (params.containsKey("recordType") && "3".equals(params.get("recordType"))) {
			if (!params.containsKey("ext_codingRate") || "".equals(params.get("ext_codingRate"))) {
				return ResultResponse.error("打码量倍率为空");
			}
		}
		/**
		 * 用户ID
		 */
		params.put("operator", getUserId() + "");
		userMemberService.addAmount(params);

		return ResultResponse.success();
	}

	/**
	 * 
	 * @Description (修改代理商)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/editTopUidName")
	// @RequiresPermissions("member:user:editTopUidName")
	@ApiOperation(value = "修改代理商", notes = "修改代理商", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse editTopUidName(@RequestBody Map<String, String> params) throws Exception {

		if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
			return ResultResponse.error("会员ID为空");
		}
		if (!params.containsKey("topUid") || "".equals(params.get("topUid"))) {
			return ResultResponse.error("代理商ID为空");
		}
		try {
			userMemberService.editTopUidName(params);
			return ResultResponse.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultResponse.error("修改代理商异常");
		}
	}

	/**
	 * 
	 * @Description (发送站内信)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/sendMessage")
	// @RequiresPermissions("member:user:sendMessage")
	@ApiOperation(value = "发送站内信", notes = "发送站内信", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse sendMessage(@RequestBody Map<String, String> params) throws Exception {

		try {
			if (!params.containsKey("uids") || "".equals(params.get("uids"))) {
				return ResultResponse.error("会员ID为空");
			}
			if (!params.containsKey("message") || "".equals(params.get("message"))) {
				return ResultResponse.error("站内信为空");
			}
			params.put("ruid", getUserId() + "");
			internalMessageService.sendMessage(params);
			return ResultResponse.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultResponse.error("发送站内信失败");
		}
	}

	/**
	 * 
	 * @Description (获取平台商所属分层)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/obtainUserType")
	// @RequiresPermissions("member:user:obtainUserType")
	@ApiOperation(value = "获取平台商所属分层", notes = "获取平台商所属分层", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse obtainUserType(@RequestBody Map<String, String> params) throws Exception {

		try {
			if (!params.containsKey("cagent") || "".equals(params.get("cagent"))) {
				return ResultResponse.error("平台商为空");
			}
			UserType usertype = userTypeService.obtainUserType(params);
			return ResultResponse.success("获取会员分层下拉列表成功", usertype);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultResponse.error("获取会员分层下拉列表异常");
		}
	}

	/**
	 * 
	 * @Description (调用会员分层)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/editUserType")
	// @RequiresPermissions("member:user:editUserType")
	@ApiOperation(value = "会员层级", notes = "会员层级", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse editUserType(@RequestBody Map<String, String> params) throws Exception {

		try {
			if (!params.containsKey("typeid") || "".equals(params.get("typeid"))) {
				return ResultResponse.error("会员分层为空");
			}
			if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
				return ResultResponse.error("会员ID为空");
			}
			userMemberService.editUserType(params);
			return ResultResponse.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultResponse.error("调用会员分层异常");
		}
	}

	/**
	 * 
	 * @Description (会员返水)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/userMemberTs")
	// @RequiresPermissions("member:user:userMemberTs")
	@ApiOperation(value = "会员返水", notes = "查询会员返水", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse userMemberTs(@RequestBody Map<String, String> params) throws Exception {

		try {
			if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
				return ResultResponse.error("会员ID为空");
			}
			List<UserMemberTs> userMemberTs = userMemberService.userMemberTs(params);
			return ResultResponse.success("获取会员返水成功", userMemberTs);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultResponse.error("获取会员返水异常");
		}
	}

	/**
	 * 
	 * @Description (给予返水)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/confirmTs")
	// @RequiresPermissions("member:user:confirmTs")
	@ApiOperation(value = "会员返水", notes = "给予返水", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse confirmTs(@RequestBody Map<String, String> params, HttpServletRequest request)
			throws Exception {

		if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
			return ResultResponse.error("会员ID为空");
		}
		params.put("ruid", getUserId() + "");
		params.put("IP", IPUtils.getIpFromRequest(request));
		userMemberService.confirmTs(params);
		return ResultResponse.success();
	}

	/**
	 * 
	 * @Description (返水清零)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/updateMakeZero")
	// @RequiresPermissions("member:user:updateMakeZero")
	@ApiOperation(value = "会员清零", notes = "给予清零", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultResponse updateMakeZero(@RequestBody Map<String, String> params) throws Exception {

		try {
			if (!params.containsKey("uid") || "".equals(params.get("uid"))) {
				return ResultResponse.error("会员ID为空");
			}
			userMemberService.updateMakeZero(params);
			return ResultResponse.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultResponse.error("返水清零异常");
		}
	}

}
