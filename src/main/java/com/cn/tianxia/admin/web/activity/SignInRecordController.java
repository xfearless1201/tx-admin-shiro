package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.SigninRecord;
import com.cn.tianxia.admin.service.txdata.SigninRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:38
 * @Description: 签到记录controller
 */
@RestController
@RequestMapping("/activity/signin")
@Slf4j
public class SignInRecordController {

    @Autowired
    SigninRecordService signinRecordService;

    @RequestMapping("/record")
//    @RequiresPermissions("activity:signin:record")
    public ResultResponse signInRecord(@RequestParam Map<String,String> params) {
        Pager<SigninRecord> pager = signinRecordService.list(params);
        return ResultResponse.success("查询成功", pager);
    }

}
