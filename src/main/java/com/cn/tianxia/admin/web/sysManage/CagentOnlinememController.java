package com.cn.tianxia.admin.web.sysManage;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.CagentOnlinemem;
import com.cn.tianxia.admin.service.txdata.CagentOnlinememService;
import com.cn.tianxia.admin.web.sys.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  * @ClassName CagentOnlinemem
 *  * @Description 线上会员配置
 *  * @Author dylonz
 *  * @Date 2019年05月13日 14:25
 *  * @Version 1.0.0
 *  
 **/
@Api(tags = "线上会员配置接口")
@RestController
@RequestMapping("/cagent/onlinemem")
public class CagentOnlinememController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CagentOnlinememController.class);

    @Autowired
    public CagentOnlinememService cagentOnlinememService;

    @ApiOperation(value ="查询线上会员配置列表",notes = "查询线上会员配置列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/getList")
    public ResultResponse getList(@RequestBody Map<String,String> params){
        try {
            Pager<CagentOnlinemem> allOnlinemems = cagentOnlinememService.getAllOnlinemem(params);
            return ResultResponse.success("success",allOnlinemems);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询线上会员配置信息异常：{}",e.getMessage());
            return ResultResponse.error("查询线上会员配置信息异常");

        }
    }

    @ApiOperation(value = "添加线上会员配置",notes = "添加线上会员配置",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/addOnlinemem")
    public ResultResponse addOnlinemem(@RequestBody CagentOnlinemem cagentOnlinemem){
        try{
            cagentOnlinememService.insertSelective(cagentOnlinemem);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("新增线上会员配置信息异常:{}",e.getMessage());
            return ResultResponse.error("新增线上会员配置信息异常");
        }
    }

    @ApiOperation(value = "编辑线上会员配置",notes = "编辑线上会员配置",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/editOnlinemem")
    public ResultResponse editOnlinemem(@RequestBody CagentOnlinemem cagentOnlinemem){
        try {
            cagentOnlinememService.updateByPrimaryKeySelective(cagentOnlinemem);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("编辑线上会员配置信息异常:{}",e.getMessage());
            return ResultResponse.error("编辑线上会员配置信息异常");
        }
    }

    @ApiOperation(value = "删除线上会员配置信息",notes = "删除线上会员配置信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delOnlinemem/{id}")
    public ResultResponse delOnlinemem(@PathVariable(value = "id",required = true) Integer id){
        try {
            cagentOnlinememService.deleteByPrimaryKey(id);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("删除线上会员配置信息异常:{}",e.getMessage());
            return ResultResponse.error("删除线上会员配置信息异常");
        }
    }

    @ApiOperation(value = "查询某条线上会员配置信息",notes = "查询某条线上会员配置信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/info/{id}")
    public ResultResponse info(@PathVariable(value = "id",required = true)Integer id){
        CagentOnlinemem cagentOnlinemem = cagentOnlinememService.selectByPrimaryKey(id);
        return ResultResponse.success("success",cagentOnlinemem);
    }
}
