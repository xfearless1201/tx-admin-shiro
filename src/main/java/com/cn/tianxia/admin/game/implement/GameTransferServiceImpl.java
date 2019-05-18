package com.cn.tianxia.admin.game.implement;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.domain.txdata.*;
import com.cn.tianxia.admin.enums.GameTypeEnum;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.game.GameTransferService;
import com.cn.tianxia.admin.game.enums.TransferResultEnum;
import com.cn.tianxia.admin.game.service.BaseGameService;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import com.cn.tianxia.admin.project.txdata.PlatformConfig;
import com.cn.tianxia.admin.project.txdata.Transfer;
import com.cn.tianxia.admin.project.txdata.TransferFaild;
import com.cn.tianxia.admin.project.txdata.UserGamestatus;
import com.cn.tianxia.admin.utils.DESEncrypt;
import com.cn.tianxia.admin.utils.RedisUtils;
import com.cn.tianxia.admin.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisCluster;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Author: zed
 * @Date: 2019/5/5 14:49
 * @Description: 游戏转账接口实现类
 */
@Service
@Slf4j
public class GameTransferServiceImpl implements GameTransferService {

    @Autowired
    private PlatformConfigMapper platformConfigMapper;
    @Autowired
    private PlatformStatusMapper platformStatusMapper;
    @Autowired
    private TransferMapper transferMapper;
    @Autowired
    private TransferFaildMapper transferFaildMapper;
    @Autowired
    private UserGamestatusMapper userGamestatusMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisUtils redisUtils;

    static SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");




    @Override
    public ResultResponse transferOut(TransferBaseInfo baseInfo) throws BusinessException {
        log.info("调用天下平台向游戏平台转入金额(游戏上分)接口开始================START=====================");
        log.info("transferIn(TransferBaseInfo baseInfo = {} -start" , baseInfo);
        ResultResponse resultResponse = null;
        try{
            checkGamePlatform(baseInfo);
            String type = GameTypeEnum.valueOf(baseInfo.getGameType()).getGameType();
            synchronized (baseInfo.getAg_username().intern()){

                Double balance = transferMapper.getBalance(Integer.valueOf(baseInfo.getUid()));
                int credit = Integer.parseInt(baseInfo.getCredit());

                if (balance < credit) {
                    log.info("用户【"+baseInfo.getAg_username()+"】钱包余额不足！");
                    throw new BusinessException(CommonErrorEnum.WALLET_BALANCE_NOT_SUFFICIENT);
                }

                String billno = generatorOrderNo(baseInfo.getGameType(),baseInfo.getAg_username(),baseInfo.getConfig());
                if(StringUtils.isEmpty(billno))   throw new BusinessException(CommonErrorEnum.CREATE_TRANSFER_ORDER_FAIL);

                log.info("用户【"+baseInfo.getAg_username()+"】调用转账接口,生成订单号【"+billno+"】");
                baseInfo.setBillno(billno);
                int i = sysUserMapper.updateWelletTransferOut(baseInfo.getUid(),Double.valueOf(credit));
                if(1 > i)  throw new BusinessException(CommonErrorEnum.GAME_TRANSFER_ERROR);

                BaseGameService service = (BaseGameService) SpringContextUtils.getBean(type);
                TransferResultEnum transferInResult = service.transferIn(baseInfo);
                log.info("用户【"+baseInfo.getAg_username()+"】,调用天下平台向游戏平台转入金额(游戏上分)接口,发起第三方请求结果:{}",transferInResult.getMessage());

                int num = 0 ;
                if(TransferResultEnum.SUCCESS == transferInResult){
                    num =  transferMapper.insertSelective(setTransferEntity(baseInfo,balance,transferInResult.getStatus(),"OUT"));
                }else if(TransferResultEnum.FAILED == transferInResult){

                    if(sysUserMapper.updateWelletTransferIn(baseInfo.getUid(),Double.valueOf(credit))> 0)
                       num =  transferFaildMapper.insertSelective(setTransferFaildEntity(baseInfo,transferInResult.getStatus(),"OUT"));
                    else
                       num = transferFaildMapper.insertSelective(setTransferFaildEntity(baseInfo,transferInResult.getStatus(),"OUT"));
                }else{
                    num = transferFaildMapper.insertSelective(setTransferFaildEntity(baseInfo,transferInResult.getStatus(),"OUT"));
                }
                log.info("用户【"+baseInfo.getAg_username()+"】 新增流水记录执行行数："+ num +"条");

                if(1 > num) throw new BusinessException(CommonErrorEnum.INSERT_TRANSFER_RECORD_FAIL);

                resultResponse.setStatus( transferInResult == TransferResultEnum.SUCCESS?0:1);
                resultResponse.setCode(transferInResult.getStatus());
                resultResponse.setMsg(transferInResult == TransferResultEnum.SUCCESS?"转账成功！":"转账失败！");
            }

        }catch (Exception e){
            log.error("用户【"+baseInfo.getAg_username()+"】 转账至游戏失败！",e);
            throw new BusinessException(CommonErrorEnum.GAME_TRANSFER_ERROR);
        }
        return resultResponse;

    }

    @Override
    public ResultResponse transferIn(TransferBaseInfo baseInfo)throws BusinessException{
        log.info("调用从游戏平台转向天下平台转出金额(游戏下分)开始===================start====================");
        log.info("transferOut(TransferBaseInfo baseInfo = -start {}",baseInfo);
        ResultResponse resultResponse = null;
        try{
            checkGamePlatform(baseInfo);
            synchronized (baseInfo.getAg_username().intern()){
                String billno = generatorOrderNo(baseInfo.getGameType(),baseInfo.getAg_username(),baseInfo.getConfig());
                if(StringUtils.isEmpty(billno))   throw new BusinessException(CommonErrorEnum.CREATE_TRANSFER_ORDER_FAIL);

                Double balance = transferMapper.getBalance(Integer.valueOf(baseInfo.getUid()));

                log.info("用户【"+baseInfo.getAg_username()+"】调用转账接口,生成订单号【"+billno+"】");
                BaseGameService service = (BaseGameService) SpringContextUtils.getBean(baseInfo.getGameType());

                TransferResultEnum transferResult = service.transferOut(baseInfo);
                log.info("用户【"+baseInfo.getAg_username()+"】 调用游戏下分到平台接口返回结果：{}",transferResult);
                if(TransferResultEnum.SUCCESS == transferResult)
                    insertUserTransferIn(baseInfo,balance,transferResult.getStatus());
                else
                    setTransferFaildEntity(baseInfo,transferResult.getStatus(),"IN");

                resultResponse.setStatus(TransferResultEnum.SUCCESS == transferResult?0:1);
                resultResponse.setCode(transferResult.getStatus());
                resultResponse.setMsg(TransferResultEnum.SUCCESS == transferResult?"转账成功！":"转账失败！");
            }

        }catch (Exception e){
           log.error("用户【"+baseInfo.getAg_username()+"】 游戏转账至平台失败！",e);
           throw  e;
        }

        return  resultResponse;

    }

    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public int insertUserTransferIn(TransferBaseInfo baseInfo,double balance , String status) {
        log.info("insertUserTransferIn(Transfer transfer ={}",baseInfo);
        try {
            // 首先插入转账转入成功订单
            transferMapper.insertSelective(setTransferEntity(baseInfo,balance,status,"IN"));
            // 添加用户金额
            Integer i = sysUserMapper.updateWelletTransferIn(baseInfo.getUid(),Double.valueOf(baseInfo.getCredit()));
            log.info("insertUserTransferIn(Map<String, Object> data)写入数据成功！ 订单号:"+baseInfo.getBillno() +"执行行数 i："+ i);
            return i;
        } catch (Exception e) {
            log.error("用户【"+baseInfo.getUsername()+"】,订单号：【"+baseInfo.getBillno()+"】写入转入数据异常:{}",e);
            throw e;
        }

    }


    private Transfer setTransferEntity(TransferBaseInfo transferBaseInfo,Double balance,String status,String type){
        Transfer transfer = new Transfer();
        transfer.setUid(Integer.valueOf(transferBaseInfo.getUid()));
        transfer.setBillno(transferBaseInfo.getBillno());
        transfer.setUsername(transferBaseInfo.getAg_username().toLowerCase());
        transfer.settType(type);
        transfer.settMoney(Float.valueOf(transferBaseInfo.getCredit()));
        transfer.setOldMoney(Float.valueOf(balance+""));
        transfer.setNewMoney(Float.valueOf((balance - Double.valueOf(transferBaseInfo.getCredit()))+""));
        transfer.setType(transferBaseInfo.getGameType());
        transfer.setIp(transferBaseInfo.getIp());
        transfer.settTime(new Date());
        transfer.setStatus(1);
        transfer.setResult(status);
        transfer.setDescription("转账成功！");
        return  transfer;
    }

    private TransferFaild setTransferFaildEntity(TransferBaseInfo transferBaseInfo,String status,String type){
        TransferFaild transferFaild = new TransferFaild();
        transferFaild.setUid(Integer.valueOf(transferBaseInfo.getUid()));
        transferFaild.setBillno(transferBaseInfo.getBillno());
        transferFaild.setUsername(transferBaseInfo.getAg_username().toLowerCase());
        transferFaild.settType(type);
        transferFaild.settMoney(Float.valueOf(transferBaseInfo.getCredit()));
        transferFaild.setType(transferBaseInfo.getGameType());
        transferFaild.setIp(transferBaseInfo.getIp());
        transferFaild.settTime(new Date());
        transferFaild.setStatus("1");
        transferFaild.setResult(status);
        return  transferFaild;
    }




    @Override
    public JSONObject getBalance(TransferBaseInfo baseInfo) throws Exception {

        // 加密密码
        DESEncrypt d = new DESEncrypt("tianxia88");
        String password = d.decrypt(baseInfo.getAg_password());
        baseInfo.setAg_password(password);

        if ("WALLET".equals(baseInfo.getGameType())) {
            double balance = transferMapper.getBalance(Integer.valueOf(baseInfo.getUid()));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("balance", balance);
            return jsonObject;
        }

        // 通过游戏编码查询游戏配置，检查游戏维护状态
        JSONObject config = getGameConfigAndcheckStatus(baseInfo.getCid(), baseInfo.getCagent(), baseInfo.getGameType());
        baseInfo.setConfig(config);

        // 查询用户是否玩过当前游戏
        if (checkLocalGameReg(baseInfo.getGameType(), baseInfo.getUid())) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("balance", 0);
            return jsonObject;
        }

        String type = GameTypeEnum.valueOf(baseInfo.getGameType()).getGameType();

        BaseGameService service = (BaseGameService) SpringContextUtils.getBean(type);

        return service.queryBalace(baseInfo);
    }

    @Override
    public JSONObject forwardGame(TransferBaseInfo baseInfo) throws Exception {
        // 解密密码
        DESEncrypt d = new DESEncrypt("tianxia88");
        String password = d.decrypt(baseInfo.getAg_password());
        baseInfo.setAg_password(password);

        String type = GameTypeEnum.valueOf(baseInfo.getGameType()).getGameType();
        // 通过游戏编码查询游戏配置，检查游戏维护状态
        checkGamePlatform(baseInfo);

        BaseGameService service = (BaseGameService) SpringContextUtils.getBean(type);

        return service.getLink(baseInfo);
    }

    private void checkGamePlatform(TransferBaseInfo baseInfo) {
        // 通过游戏编码查询游戏配置，检查游戏维护状态
        JSONObject gameConfig = getGameConfigAndcheckStatus(baseInfo.getCid(),baseInfo.getCagent(),baseInfo.getGameType());
        baseInfo.setConfig(gameConfig);

        if (checkLocalGameReg(baseInfo.getGameType(), baseInfo.getUid())) {  //检查用户是否玩过当前游戏
            if (checkGameReg(baseInfo)) {  //如未玩过到第三方检查或创建用户
                throw new BusinessException(CommonErrorEnum.CREATE_OR_CHECK_ACCOUNT_FAIL);
            }
        }
    }

    /**
     * 检查游戏状态,获取游戏配置
     * @param cid 平台id
     * @param cagent  平台编码
     * @param gameType 游戏type
     * @return 平台游戏配置
     * @throws BusinessException 业务异常
     */
    private JSONObject getGameConfigAndcheckStatus(String cid, String cagent, String gameType) throws BusinessException {
        log.info("getGameConfigAndcheckStatus( cid = {},  cagent ={},  gameType={}",cid ,cagent ,gameType);

        JSONObject jsonObject = null;

        if (redisUtils.hasKey(gameType+"gameConfig")){

            jsonObject = JSONObject.parseObject(redisUtils.get(gameType+"gameConfig"));
            if(redisUtils.hasKey(cid+gameType)){
                if(!redisUtils.get(cagent+gameType).equals("1")) throw new BusinessException(CommonErrorEnum.CAGENT_GAME_CLOSED);
            }else{

                Short cagentGameStatus = platformStatusMapper.selectByCidAndType(cid,GameTypeEnum.valueOf(gameType).getGameCode());
                log.info("查询平台【" + cagent + "】游戏gameCode【" + GameTypeEnum.valueOf(gameType).getGameCode() + "】游戏开关状态:{}", cagentGameStatus);
                if (null == cagentGameStatus || 1 != cagentGameStatus) throw new BusinessException(CommonErrorEnum.CAGENT_GAME_CLOSED);
            }
        }else{

            String type = GameTypeEnum.valueOf(gameType).getGameType();
            PlatformConfig platformConfig = platformConfigMapper.selectByPlatformKey(type);
            String val = platformConfig.getPlatformConfig();

            if (null == platformConfig || StringUtils.isBlank(val)) {
                log.info("查询平台【" + cagent + "】游戏【" + gameType + "】维护中.....");
                throw new BusinessException(CommonErrorEnum.PLATFORM_IN_MAINTENANCE);
            }

            JSONObject config = JSONObject.parseObject(platformConfig.getPlatformConfig());
            val = config.containsKey(cagent)?config.getString(cagent):config.getString("ALL");

            String gameCode = GameTypeEnum.valueOf(gameType).getGameCode();

            Short cagentGameStatus = platformStatusMapper.selectByCidAndType(cid,gameCode);
            if (null == cagentGameStatus || 1 != cagentGameStatus) {
                log.info("查询平台【" + cagent + "】游戏gameCode【" + gameCode + "】游戏开关状态:{}", cagentGameStatus);
                throw new BusinessException(CommonErrorEnum.CAGENT_GAME_CLOSED);
            }

            redisUtils.set(cid+gameType,String.valueOf(cagentGameStatus));
            redisUtils.set(gameType+"gameConfig",JSONObject.parseObject(val).toString());
            jsonObject = JSONObject.parseObject(val);
        }
        log.info("平台【"+cagent+"】,游戏【"+gameType+"】游戏配置【"+jsonObject+"】");
        return  jsonObject;
    }

    private boolean checkLocalGameReg(String gameType, String uid) {
        log.info("checkLocalGameReg(String gameType = {}, String uid = {}",gameType,uid);

        String type = GameTypeEnum.valueOf(gameType).getGameType();
        String isGameType = "is_" + type.toLowerCase();
        Integer status = userGamestatusMapper.selectUserGameStatus(uid,isGameType);
        log.info("用户游戏状态,游戏gameType【"+gameType+"】,游戏状态：{}",status);

        return status == null || status == 0;
    }

    private boolean checkGameReg(TransferBaseInfo vo) {
        String type = GameTypeEnum.valueOf(vo.getGameType()).getGameType();
        String gameType = "is_" + type.toLowerCase();
        BaseGameService service = (BaseGameService) SpringContextUtils.getBean(type);

        JSONObject result = service.checkOrCreateAccount(vo);
        if ("success".equalsIgnoreCase(result.getString("msg"))) {
            log.info("检查或创建用户成功:{}", result.getString("msg"));
            UserGamestatus gameStatus = new UserGamestatus();
            gameStatus.setUid(Integer.parseInt(vo.getUid()));
            gameStatus.setGametype(gameType);
            gameStatus.setStatus("1");
            gameStatus.setAddtime(new Date());
            userGamestatusMapper.insertSelective(gameStatus);
            return false;
        } else {
            log.error("检查或创建用户失败:{}",result.getString("msg"));
            return true;
        }
    }

    /**
     * @Description 生成订单号
     * @param type 游戏type
     * @return 转账订单号
     * @throws BusinessException 业务异常
     */
    private synchronized String generatorOrderNo(String type, String ag_username, JSONObject config) throws BusinessException {
        try {
            //同步方法随机休眠5毫秒，以生成不同的订单号
            Random interval = new Random();
            Thread.sleep(interval.nextInt(9));
            int randInt = (int)((Math.random()*9+1)*1000); // 4位随机数
            String billno = type + System.currentTimeMillis() + randInt;
            switch (type) {
                case "BBIN":
                case "BG":
                    //转帐序号(唯一值)，可用贵公司转帐纪录的流水号，以避免重覆转帐< 请用int(19)( 1~9223372036854775806)来做设定 >
                    billno = String.valueOf(System.currentTimeMillis()) + randInt;//生成一个18位字符串
                    break;
                case "OB":
                    billno = String.valueOf(System.currentTimeMillis());
                    break;
                case "GGBY":{
                    String cagent = config.getString("cagent");
                    billno = cagent + System.currentTimeMillis() + (int)((Math.random()*9+1)*100);
                    break;
                }
                case "KYQP": {
                    String api_cagent = config.getString("api_cagent");
                    billno = api_cagent + simpleDateFormat.format(new Date()) + ag_username;
                    break;
                }
                case "LYQP": {
                    String api_cagent = config.getString("api_cagent");
                    billno = api_cagent + simpleDateFormat.format(new Date()) + ag_username;
                    break;
                }
                case "IM": {
                    billno = "IM"+ UUID.randomUUID();
                    break;
                }
                case "NWG":{
                    billno = config.getString("agent") + simpleDateFormat.format(new Date()) + ag_username;
                    break;
                }
            }
            return billno;
        } catch (Exception e) {
            log.info("生成转账订单号异常:{}", e.getMessage());
            throw new BusinessException(CommonErrorEnum.CREATE_TRANSFER_ORDER_FAIL);
        }
    }
}
