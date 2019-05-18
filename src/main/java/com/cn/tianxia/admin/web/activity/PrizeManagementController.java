package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.PrizeDetails;
import com.cn.tianxia.admin.service.txdata.PrizeDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:31
 * @Description: 奖品管理controller
 */
@RestController
@RequestMapping("/activity/prize")
@Slf4j
public class PrizeManagementController {

    @Autowired
    private PrizeDetailsService prizeDetailsService;

    @RequestMapping("/list")
    public ResultResponse prizeList(@RequestParam Map<String,String> params) {
        Pager<PrizeDetails> pager = prizeDetailsService.list(params);
        return ResultResponse.success("查询成功", pager);
    }

}
