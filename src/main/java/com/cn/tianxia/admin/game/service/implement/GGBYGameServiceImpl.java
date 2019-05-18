package com.cn.tianxia.admin.game.service.implement;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.game.enums.RequestTypeEnum;
import com.cn.tianxia.admin.game.enums.TransferResultEnum;
import com.cn.tianxia.admin.game.service.BaseGameService;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import org.springframework.stereotype.Service;

/**
 * @Author: zed
 * @Date: 2019/5/8 20:33
 * @Description: GG捕鱼 game service implement
 */
@Service("GGBY")
@Slf4j
public class GGBYGameServiceImpl extends BaseGameService {

    private static String api_url;
    private static String api_deskey;
    private static String api_md5key;
    private static String cagent;
    private static String actype;
    private static String ishttps = "1";//正式环境

    @Override
    public void init(TransferBaseInfo baseInfo) {
        if (null == baseInfo.getConfig()) {
            throw new BusinessException(CommonErrorEnum.GAME_CONFIG_IS_EMPTY);
        }
        JSONObject jo = baseInfo.getConfig();
        api_deskey = jo.getString("api_deskey");
        api_url = jo.getString("api_url");
        api_md5key = jo.getString("api_md5key");
        cagent = jo.getString("cagent");
        actype = jo.getString("actype");

        if (jo.containsKey("ishttps")) {
            ishttps = "0";//测试环境
        }
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

    /**
     * 根据请求类型构造请求链接发起请求
     *
     * @param type 请求类型
     * @param info 请求参数
     * @return 请求结果
     * @throws Exception 请求第三方异常
     */
    private String sendRequest(RequestTypeEnum type, TransferBaseInfo info) throws Exception {
        String xmlString = null;
        switch (type) {
            case CHECK_OR_CREATE:
                xmlString = "cagent=" + cagent + "/\\\\/loginname=" + info.getAg_username() + "/\\\\/method=ca/\\\\/actype=" + actype
                        + "/\\\\/password=" + info.getAg_password() + "/\\\\/cur=CNY";
                break;
            case QUERY_BALANCE:
                xmlString = "cagent=" + cagent + "/\\\\/loginname=" + info.getAg_username() + "/\\\\/method=gb/\\\\/password=" + info.getAg_password() + "/\\\\/cur=CNY";
                break;
            case PREPARE_TRANSFER:
                xmlString = "cagent=" + cagent + "/\\\\/method=tc/\\\\/loginname=" + info.getAg_username() + "/\\\\/billno=" + info.getBillno()
                        + "/\\\\/type=" + type + "/\\\\/credit=" + info.getCredit() + "/\\\\/actype=" + actype + "/\\\\/password="
                        + info.getAg_password() + "/\\\\/cur=" + "CNY";
                break;
            case CONFIRM_TRANSFER:
                xmlString = "cagent=" + cagent + "/\\\\/method=tc/\\\\/loginname=" + info.getAg_username() + "/\\\\/billno=" + cagent + info.getBillno()
                        + "/\\\\/type=" + type + "/\\\\/credit=" + info.getCredit() + "/\\\\/password=" + info.getAg_password() + "/\\\\/cur=CNY/\\\\/ip==" + info.getIp();
                break;
            case QUERY_ORDER:
                xmlString = "cagent=" + cagent + "/\\\\/method=qx/\\\\/billno=" + info.getBillno();
                break;
            case GET_LINK:
                String sid = "TE179" + System.currentTimeMillis();
                xmlString = "cagent=" + cagent + "/\\\\/loginname=" + info.getAg_username() + "/\\\\/password=" + info.getAg_password()
                        + "/\\\\/method=fw/\\\\/sid=" + sid + "/\\\\/lang=zh-CN/\\\\/gametype=0/\\\\/ip=" + info.getIp() + "/\\\\/ishttps=" + ishttps;

        }
        String targetUrl = getAGUrl(api_url, xmlString, api_deskey, api_md5key);
        Headers.Builder builder = new Headers.Builder();
        builder.add("User-Agent", "WEB_LIB_GI_" + cagent)
                .add("Content-Type", "text/xml")
                .add("charset", "utf-8");
        return super.get(targetUrl, builder.build());
    }

}
