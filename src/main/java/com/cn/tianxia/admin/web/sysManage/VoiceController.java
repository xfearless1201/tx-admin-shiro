
package com.cn.tianxia.admin.web.sysManage;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.Voice;
import com.cn.tianxia.admin.service.txdata.VoiceService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 *  * @ClassName VoiceController
 *  * @Description 声音管理
 *  * @Author dylonz
 *  * @Date 2019年04月30日 10:35
 *  * @Version 1.0.0
 *  
 **/
@Api(tags="声音管理接口")
@RestController
@RequestMapping("/voice")
public class VoiceController extends BaseController {

    @Autowired
    private VoiceService voiceService;

    @ApiOperation(value = "查询声音管理所有信息",notes = "查询声音管理所有信息" ,httpMethod = "POST" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/getList")
    public ResultResponse getVoiceList(@RequestBody Map<String,String> params){
        try {
            Pager<Voice> voices = voiceService.getAllVoice(params);
            return ResultResponse.success("success",voices);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询声音管理信息异常:{}",e.getMessage());
            return ResultResponse.error("查询声音管理信息异常");
        }
    }

    @ApiOperation(value = "新增声音相关信息", notes = "新增声音相关信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/addVoice")
    public ResultResponse addVoice(@RequestBody Voice voice){
        try {
            voice.setStatus("0");
            voice.setAddtime(new Date());
            voice.setAdduid(getUserId().intValue());
            voiceService.insertSelective(voice);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("新增声音管理信息异常:{}",e.getMessage());
            return ResultResponse.error("新增声音管理信息异常");
        }
    }

    @ApiOperation(value = "编辑声音相关信息",notes = "编辑声音相关信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/editVoice")
    public ResultResponse editVoice(@RequestBody Voice voice){
        try {
            voiceService.updateByPrimaryKeySelective(voice);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("编辑声音管理信息异常:{}",e.getMessage());
            return ResultResponse.error("编辑声音管理信息异常");
        }
    }

    @ApiOperation(value = "删除声音相关信息",notes = "删除声音相关信息",httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delVoice/{id}")
    public ResultResponse delVoice(@PathVariable(value = "id",required = true) Integer id){
        try {
            voiceService.deleteByPrimaryKey(id);
            return ResultResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("删除声音管理信息异常:{}",e.getMessage());
            return ResultResponse.error("删除声音管理信息异常");
        }
    }

    @ApiOperation(value = "查询某条声音相关信息", notes = "查询某条声音相关信息",httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/info/{id}")
    public ResultResponse info(@PathVariable(value = "id",required = true) Integer id){
        Voice voice = voiceService.selectByPrimaryKey(id);
        return ResultResponse.success("success",voice);
    }
}
