package com.cn.tianxia.admin.web.sys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.service.txdata.SysLoginService;
import com.cn.tianxia.admin.utils.RequestResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName LoginController
 * @Description 系统登录接口
 * @author Hardy
 * @Date 2019年4月17日 上午9:57:12
 * @version 1.0.0
 */
@Api(tags="登录接口")
@RestController
@RequestMapping("/sys")
public class SysLoginController extends BaseController {
    
    @Autowired
    private SysLoginService sysLoginService;

    /**
     * @Description 登录接口
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @ApiOperation(value = "登录接口", notes = "登录接口", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/login")
    public ResultResponse login(HttpServletRequest request,HttpServletResponse response) {
        // 获取请求参数
        Map<String,String> params = RequestResponseUtil.getRequestBodyMap(request);
        if(CollectionUtils.isEmpty(params)){
            logger.error("登录请求参数结果:{}",JSONObject.toJSONString(params));
            return ResultResponse.faild("请求参数异常");
        }
        if(!params.containsKey("username") || StringUtils.isBlank(params.get("username"))){
            return ResultResponse.faild("登录账号不能为空");
        }
        if(!params.containsKey("password") || StringUtils.isBlank(params.get("password"))){
            return ResultResponse.faild("登录密码不能为空");
        }
//        if(!params.containsKey("captcha") || StringUtils.isBlank(params.get("captcha"))){
//            return ResultResponse.faild("验证码不能为空");
//        }
        String username = params.get("username");//登录账号
        String password = params.get("password");//登录密码
//        String captcha = params.get("captcha");//验证码
        // 获取用户缓存的验证码信息
        try {
//            String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//            if (!loginVO.getCaptcha().equalsIgnoreCase(kaptcha)) {
//                return ResultResponse.faild("验证码输入不正确!");
//            }
            return sysLoginService.login(username, password);
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("用户:{}调用登录接口异常!!!",username);
            return ResultResponse.error("登录异常,请联系客服");
        }
    }
    
    /**
     * 
     * @Description 登出接口
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "用户登出接口", notes = "POST用户登出销毁凭证", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/logout")
    public ResultResponse logout(HttpServletRequest request,HttpServletResponse response){
        //从请求头中获取用户信息
        Map<String,String> params = RequestResponseUtil.getRequestHeaders(request);
        if(CollectionUtils.isEmpty(params)){
            logger.error("登录请求参数结果:{}",JSONObject.toJSONString(params));
            return ResultResponse.faild("请求参数异常");
        }
        return sysLoginService.logout(params.get(Constant.AUTHORIZATION_ID));
    }
}
