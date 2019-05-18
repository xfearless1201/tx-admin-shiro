
package com.cn.tianxia.admin.web.sysManage;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.CagentMsgconfig;
import com.cn.tianxia.admin.service.txdata.CagentMsgconfigService;
import com.cn.tianxia.admin.web.sys.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 *  * @ClassName CagentMsgconfigController
 *  * @Description 短信平台配置
 *  * @Author dylonz
 *  * @Date 2019年05月15日 15:09
 *  * @Version 1.0.0
 *  
 **/
@Api(tags = "短信平台配置接口")
@RestController
@RequestMapping("/cagent/msgconfig")
public class CagentMsgconfigController extends BaseController {

    @Autowired
    private CagentMsgconfigService cagentMsgconfigService;

    @ApiOperation(value = "查询短信平台配置列表信息",notes = "查询短信平台配置列表信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/getList")
    public ResultResponse CagentMsgconfigList(@RequestBody Map<String,String> params){
        if(!isAdmin()){
            params.put("cid",getUser().getCid().toString());
        }
        try{
            Pager<CagentMsgconfig> pager = cagentMsgconfigService.findAllByCid(params);
            return ResultResponse.success("success",pager);
        }catch(Exception e){
            e.printStackTrace();
            logger.info("查询短信平台配置信息异常:{}",e.getMessage());
            return ResultResponse.error("查询短信平台配置信息异常");
        }

    }

    @ApiOperation(value = "添加短信平台配置信息",notes = "添加短信平台配置信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/addPage")
    public ResultResponse addCagentMsgconfig(@RequestBody CagentMsgconfig cagentMsgconfig){
        if(StringUtils.isBlank(cagentMsgconfig.getCid().toString())){
            cagentMsgconfig.setCid(getUser().getCid());
        }
        // 判断短信配置格式是否正确
        boolean result = judgeCagentMsgConfig(cagentMsgconfig);
        if(!result){
            return ResultResponse.error("短信配置格式出错");
        }

        try {
            // 获取更新人和更新日期
            cagentMsgconfig.setUpsn(getUserId().toString());
            cagentMsgconfig.setUdat(new Date());
            // 添加短信平台配置信息时还需判断状态status,首次添加时状态必须为启用
            int flag = cagentMsgconfigService.insertJudgeStatus(cagentMsgconfig);
            if(flag == 1){
                return ResultResponse.error("首次添加时状态必须为启用!!!");
            }
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("添加短信平台配置信息异常:{}",e.getMessage());
            return ResultResponse.error("添加短信平台配置信息异常");
        }
    }

    @ApiOperation(value = "编辑短信平台配置信息",notes = "编辑短信平台配置信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/editPage")
    public ResultResponse editCagentMsgconfig(@RequestBody CagentMsgconfig cagentMsgconfig){
        // 判断短信配置格式是否正确
        boolean result = judgeCagentMsgConfig(cagentMsgconfig);
        if(!result){
            return ResultResponse.error("短信配置格式出错");
        }
        try {
            cagentMsgconfig.setUdat(new Date());
            int flag = cagentMsgconfigService.updateJudgeStatus(cagentMsgconfig);
            if(flag == 1){
                return ResultResponse.error("必须存在一条状态为启用的数据");
            }
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("编辑短信平台配置信息异常:{}",e.getMessage());
            return ResultResponse.error("编辑短信平台配置信息异常");
        }
    }

    @ApiOperation(value = "删除短信平台配置信息",notes = "删除短信平台配置信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delPage/{id}")
    public ResultResponse delCagentMsgconfig(@PathVariable(value = "id",required = true) Integer id){
        try {
            CagentMsgconfig cagentMsgconfig = cagentMsgconfigService.selectByPrimaryKey(id);
            if("0".equals(cagentMsgconfig.getStatus())){
                return ResultResponse.error("必须存在一条状态为启用的数据");
            }
            cagentMsgconfigService.deleteByPrimaryKey(id);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("删除短信平台配置信息异常:{}",e.getMessage());
            return ResultResponse.error("删除短信平台配置信息异常");
        }
    }

    @ApiOperation(value = "查询某条线上会员配置信息",notes = "查询某条线上会员配置信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/info/{id}")
    public ResultResponse info(@PathVariable(value = "id",required = true)Integer id){
        CagentMsgconfig cagentMsgconfig = cagentMsgconfigService.selectByPrimaryKey(id);
        return ResultResponse.success("success",cagentMsgconfig);
    }

    /**
     * 判断短信配置格式是否正确
     * @param cagentMsgconfig
     */
    private boolean judgeCagentMsgConfig(@RequestBody CagentMsgconfig cagentMsgconfig) {
        if(StringUtils.isNotBlank(cagentMsgconfig.getConfig())) {
            try {
                cagentMsgconfig.setConfig(StringEscapeUtils.unescapeHtml(cagentMsgconfig.getConfig()));
                cagentMsgconfig.setConfig(cagentMsgconfig.getConfig().replace(" ", ""));
                JSONObject.parseObject(cagentMsgconfig.getConfig());
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("短信配置格式出错:{}", e.getMessage());
                return false;
            }
        }else {
            return false;
        }
        return true;
     }
}
