package com.cn.tianxia.admin.web.game;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.game.GameTransferService;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Date: 2019/5/7 14:13
 * @Description: 游戏转账、余额查询controller
 */
@RestController
@Api(tags = "游戏转账、余额查询接口")
@RequestMapping("/game/transfer")
@Slf4j
public class GameTransferController {

    @Autowired
    private GameTransferService gameTransferService;


    @ApiOperation(value = "平台转账至游戏接口", notes = "平台转账至游戏",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultResponse transferOut(@RequestBody TransferBaseInfo transferBaseInfo) throws Exception {
        log.info("transferOut(@RequestBody TransferBaseInfo transferBaseInfo = {} -start",transferBaseInfo);
        ResultResponse resultResponse = null;
        try{
            resultResponse   = gameTransferService.transferOut(transferBaseInfo);
        }catch (Exception e){
            log.error("游戏转账到平台异常！",e);
            throw  e;
        }
        return  resultResponse;
    }

    @ApiOperation(value = "游戏转账至平台接口", notes = "游戏转账至品台",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultResponse transferIn(@RequestBody TransferBaseInfo transferBaseInfo) throws Exception {
        log.info("transferOut(@RequestBody TransferBaseInfo transferBaseInfo = {} -start",transferBaseInfo);
        ResultResponse resultResponse = null;
        try{
            resultResponse   = gameTransferService.transferIn(transferBaseInfo);
        }catch (Exception e){
            log.error("游戏转账到平台异常！",e);
            throw  e;
        }
        return  resultResponse;
    }

    @ApiOperation(value = "查询用户游戏余额接口", notes = "查询用户游戏余额",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/queryBalance")
    public ResultResponse queryBalance(@RequestBody TransferBaseInfo transferBaseInfo) {
        log.info("queryBalance(@RequestBody TransferBaseInfo transferBaseInfo = {} -start",transferBaseInfo);
        ResultResponse resultResponse = null;
        try{
            JSONObject jsonObject = gameTransferService.getBalance(transferBaseInfo);

        }catch (Exception e){
            log.error("查询用户余额失败！",e);
        }

        return resultResponse;
    }

    @ApiOperation(value = "查询用户所有游戏余额接口", notes = "查询用户所有游戏余额",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/queryAllBalance")
    public ResultResponse queryAllBalance(@RequestParam Map<String,String> params) {
        return null;
    }

    @ApiOperation(value = "转出用户游戏余额接口", notes = "转出用户游戏余额",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/transferOut")
    public ResultResponse transferOut(@RequestParam Map<String,String> params) {
        return null;
    }

    @ApiOperation(value = "转出用户所有游戏余额接口", notes = "转出用户所有游戏余额",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/transferAllOut")
    public ResultResponse transferAllOut(@RequestParam Map<String,String> params) {
        return null;
    }
}








