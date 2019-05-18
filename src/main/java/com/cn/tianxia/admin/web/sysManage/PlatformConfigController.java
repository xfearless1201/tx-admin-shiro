
package com.cn.tianxia.admin.web.sysManage;


import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.PlatformConfig;
import com.cn.tianxia.admin.service.txdata.OperatorLogService;
import com.cn.tianxia.admin.service.txdata.PlatformConfigService;
import com.cn.tianxia.admin.web.sys.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 *  * @ClassName PlatformConfigController
 *  * @Description 游戏平台管理
 *  * @Author dylonz
 *  * @Date 2019年05月14日 11:09
 *  * @Version 1.0.0
 *  
 **/
@Api(tags = "游戏平台管理接口")
@RestController
@RequestMapping("/platform/config")
public class PlatformConfigController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(PlatformConfigController.class);

    @Autowired
    private OperatorLogService operatorLogService;

    @Autowired
    private PlatformConfigService platformConfigService;

    @ApiOperation(value = "查询游戏平台管理列表",notes = "查询游戏平台管理列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/getList")
    public ResultResponse getList(@RequestBody Map<String,String> params){
        try {
            Pager<PlatformConfig> pager= platformConfigService.findAllUsePage(params);
            return ResultResponse.success("success",pager);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询游戏平台管理信息异常：{}",e.getMessage());
            return ResultResponse.error("查询游戏平台管理信息异常");
        }
    }

    @ApiOperation(value = "新增游戏平台管理信息",notes = "新增游戏平台管理信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/addPage")
    public ResultResponse addPage(@RequestBody PlatformConfig platformConfig){
        // 获取更新人id
        platformConfig.setUpdateUid(Integer.parseInt(getUserId().toString()));
        // 对特殊符号进行转码
        if(platformConfig.getPlatformConfig() != null){
            platformConfig.setPlatformConfig(StringEscapeUtils.unescapeHtml(platformConfig.getPlatformConfig().trim()));
            platformConfig.setPlatformConfig(platformConfig.getPlatformConfig().replace(" ",""));
        }
        try {
            JSONObject.parseObject(platformConfig.getPlatformConfig());
        }catch (Exception e){
            e.printStackTrace();
            return ResultResponse.error("配置信息必须为Json格式");
        }
        Date date = new Date();
        platformConfig.setAddTime(date);
        platformConfig.setUpdateTime(date);
        try {
            platformConfigService.insertSelective(platformConfig);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("新增游戏平台管理信息异常:{}",e.getMessage());
            return ResultResponse.error("新增游戏平台管理信息异常");
        }
    }

    @ApiOperation(value = "编辑游戏平台管理信息",notes = "编辑游戏平台管理信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/editPage")
    public ResultResponse editPage(@RequestBody PlatformConfig platformConfig){
        // 获取更新人id
        platformConfig.setUpdateUid(Integer.parseInt(getUserId().toString()));
        try{
            if(platformConfig.getPlatformConfig() != null){
                platformConfig.setPlatformConfig(StringEscapeUtils.unescapeHtml(platformConfig.getPlatformConfig().trim()));
                platformConfig.setPlatformConfig(platformConfig.getPlatformConfig().replace(" ",""));
            }
            JSONObject.parseObject(platformConfig.getPlatformConfig());
            platformConfig.setUpdateTime(new Date());
            platformConfigService.updateByPrimaryKeySelective(platformConfig);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("配置信息格式错误:{}",e.getMessage());
            return ResultResponse.error("配置信息格式错误,必须为Json格式");
        }

    }

    @ApiOperation(value = "删除游戏平台管理信息",notes = "删除游戏平台管理信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delPage/{id}")
    public ResultResponse delPage(@PathVariable(value = "id",required = true) Integer id, HttpServletRequest request){
        try {
            // 游戏平台管理的删除日志信息
           // operatorLogService.delPlatformConfig(id,request);
            // 删除游戏平台管理信息
            platformConfigService.deleteByPrimaryKey(id);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("删除游戏平台管理信息异常:{}",e.getMessage());
            return ResultResponse.error("删除游戏平台管理信息异常");
        }
    }

    @ApiOperation(value = "查询某条游戏平台管理信息", notes = "查询某条游戏平台管理信息",httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/info/{id}")
    public ResultResponse info(@PathVariable(value = "id",required = true) Integer id){
        PlatformConfig platformConfig = platformConfigService.selectByPrimaryKey(id);
        return ResultResponse.success("success",platformConfig);
    }
}
