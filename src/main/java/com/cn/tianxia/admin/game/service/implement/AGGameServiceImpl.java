package com.cn.tianxia.admin.game.service.implement;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.game.enums.RequestTypeEnum;
import com.cn.tianxia.admin.game.enums.TransferResultEnum;
import com.cn.tianxia.admin.game.service.BaseGameService;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import com.cn.tianxia.admin.utils.DESEncrypt;
import com.cn.tianxia.admin.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: zed
 * @Date: 2019/5/6 11:14
 * @Description: AG game service implement
 */
@Service("AG")
@Slf4j
public class AGGameServiceImpl extends BaseGameService {

    private static String api_url;
    private static String api_url_game;
    private static String api_deskey;
    private static String api_md5key;
    private static String api_cagent;
    private static String actype;

    @Override
    public void init(TransferBaseInfo baseInfo) {
        if (null == baseInfo.getConfig()) {
            throw new BusinessException(CommonErrorEnum.GAME_CONFIG_IS_EMPTY);
        }
        JSONObject jo = baseInfo.getConfig();
        api_url = jo.getString("api_url");
        api_url_game = jo.getString("api_url_game");
        api_deskey = jo.getString("api_deskey");
        api_md5key = jo.getString("api_md5key");
        api_cagent = jo.getString("api_cagent");
        actype = jo.getString("actype");
    }

    @Override
    public JSONObject queryBalace(TransferBaseInfo baseInfo) {
        this.init(baseInfo);
        try {
            String result = sendRequest(RequestTypeEnum.QUERY_BALANCE, baseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject getLink(TransferBaseInfo baseInfo) {
        this.init(baseInfo);
        try {
            String result = sendRequest(RequestTypeEnum.GET_LINK, baseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    /**
     * 根据请求类型构造请求链接发起请求
     * @param type 请求类型
     * @param info 请求参数
     * @return 请求结果
     * @throws Exception 请求第三方异常
     */
    private String sendRequest(RequestTypeEnum type, TransferBaseInfo info) throws Exception{
        String xmlString = null;
        switch (type) {
            case CHECK_OR_CREATE:
                xmlString = "cagent=" + api_cagent + "/\\\\/loginname=" + info.getAg_username() + "/\\\\/method=gb/\\\\/actype=" + actype
                        + "/\\\\/password=" + info.getAg_password() + "/\\\\/cur=" + "CNY";
                break;
            case QUERY_BALANCE:
                xmlString = "cagent=" + api_cagent + "/\\\\/loginname=" + info.getAg_username() + "/\\\\/method=gb/\\\\/actype=" + actype
                        + "/\\\\/password=" + info.getAg_password() + "/\\\\/cur=" + "CNY";
                break;
            case PREPARE_TRANSFER:
                xmlString = "cagent=" + api_cagent + "/\\\\/method=tc/\\\\/loginname=" + info.getAg_username() + "/\\\\/billno=" + info.getBillno()
                        + "/\\\\/type=" + type + "/\\\\/credit=" + info.getCredit() + "/\\\\/actype=" + actype + "/\\\\/password="
                        + info.getAg_password() + "/\\\\/cur=" + "CNY";
                break;
            case CONFIRM_TRANSFER:
                xmlString = "cagent=" + api_cagent + "/\\\\/loginname=" + info.getAg_username() + "/\\\\/method=tcc/\\\\/billno=" + info.getBillno()
                        + "/\\\\/type=" + type + "/\\\\/credit=" + info.getCredit() + "/\\\\/actype=" + actype + "/\\\\/flag=" + "1"
                        + "/\\\\/password=" + info.getAg_password() + "/\\\\/cur=" + "CNY";
                break;
            case QUERY_ORDER:
                xmlString = "cagent=" + api_cagent + "/\\\\/billno=" + info.getBillno() + "/\\\\/method=qos" + "/\\\\/actype=" + actype
                        + "/\\\\/cur=" + "CNY";
                break;
            case GET_LINK:
                if ("mobile".equalsIgnoreCase(info.getGameId())) {
                    xmlString = "cagent=" + api_cagent + "/\\\\/loginname=" + info.getAg_username() + "/\\\\/actype=" + actype
                            + "/\\\\/password=" + info.getAg_password() + "/\\\\/dm=" + info.getIp() + "/\\\\/sid=" + "AG" + System.currentTimeMillis() + "/\\\\/lang=1/\\\\/gameType="
                            + info.getGameType() + "/\\\\/oddtype=" + info.getHandicap() + "/\\\\/cur=CNY/\\\\/mh5=y/\\\\/session_token="
                            + UUID.randomUUID().toString();
                } else {
                    xmlString = "cagent=" + api_cagent + "/\\\\/loginname=" + info.getAg_username() + "/\\\\/actype=" + actype
                            + "/\\\\/password=" + info.getAg_password() + "/\\\\/dm=" + info.getIp() + "/\\\\/sid=" + "AG" + System.currentTimeMillis() + "/\\\\/lang=1/\\\\/gameType="
                            + info.getGameType() + "/\\\\/oddtype=" + info.getHandicap() + "/\\\\/cur=CNY";
                }

                return getAGUrl(api_url_game, xmlString, api_deskey, api_md5key);
        }
        String targetUrl = getAGUrl(api_url, xmlString, api_deskey, api_md5key);
        Headers.Builder builder = new Headers.Builder();
        builder.add("User-Agent", "WEB_LIB_GI_" + api_cagent)
                .add("Content-Type", "text/xml")
                .add("charset", "utf-8");
        return super.post(null, targetUrl, builder.build());
    }


}
