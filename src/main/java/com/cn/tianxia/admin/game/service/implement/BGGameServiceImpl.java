package com.cn.tianxia.admin.game.service.implement;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.game.enums.TransferResultEnum;
import com.cn.tianxia.admin.game.service.BaseGameService;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: zed
 * @Date: 2019/5/8 16:52
 * @Description: BG 视讯 game service implement
 */
@Service("BG")
@Slf4j
public class BGGameServiceImpl extends BaseGameService {

    private static String apiurl;
    private static String jsonrpc;
    private static String secretKey;
    private static String sn;
    private static String agentLoginId;
    private static String nickname;
    private static String password;

    @Override
    public void init(TransferBaseInfo baseInfo) {
        if (null == baseInfo.getConfig()) {
            throw new BusinessException(CommonErrorEnum.GAME_CONFIG_IS_EMPTY);
        }
        JSONObject jo = baseInfo.getConfig();
        jsonrpc = jo.getString("jsonrpc");
        apiurl = jo.getString("api_url");
        secretKey = jo.getString("secretKey");
        sn = jo.getString("sn");
        agentLoginId = jo.getString("agentLoginId");
        nickname = jo.getString("nickname");
        password = jo.getString("password");
    }

    @Override
    public JSONObject queryBalace(TransferBaseInfo baseInfo) {
        return null;
    }

    @Override
    public JSONObject getLink(TransferBaseInfo baseInfo) {
        return null;
    }

    @Override
    public TransferResultEnum transferIn(TransferBaseInfo baseInfo) {
        return null;
    }

    @Override
    public TransferResultEnum transferOut(TransferBaseInfo baseInfo) {
        return null;
    }

    @Override
    public JSONObject checkOrCreateAccount(TransferBaseInfo baseInfo) {
        return null;
    }

    @Override
    public JSONObject queryTransferOrder(TransferBaseInfo baseInfo) {
        return null;
    }
}
