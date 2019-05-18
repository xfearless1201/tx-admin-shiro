package com.cn.tianxia.admin.game.service.implement;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.game.enums.RequestTypeEnum;
import com.cn.tianxia.admin.game.enums.TransferResultEnum;
import com.cn.tianxia.admin.game.response.BalanceResponse;
import com.cn.tianxia.admin.game.service.BaseGameService;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import com.cn.tianxia.admin.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: zed
 * @Date: 2019/5/7 16:11
 * @Description: BBIN游戏接口实现类
 */
@Service("BBIN")
@Slf4j
public class BBINGameServiceImpl extends BaseGameService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private String tempKey;
    private String URL;
    private String gameUrl;
    private String uppername;
    private String website;
    private String lang;
    private String page_site;
    private String CreateMemberKeyB;
    private String LoginKeyB;
    private String LogoutKeyB;
    private String CheckUsrBalanceKeyB;
    private String TransferKeyB;
    private String BetRecordKeyB;
    private String PlayGameKeyB;
    private String CheckTransferKeyB;


    @Override
    public void init(TransferBaseInfo baseInfo) {
        if (null == baseInfo.getConfig()) {
            throw new BusinessException(CommonErrorEnum.GAME_CONFIG_IS_EMPTY);
        }
        JSONObject jo = baseInfo.getConfig();
        URL = jo.getString("URL");
        gameUrl = jo.getString("gameUrl");
        uppername = jo.getString("uppername");
        website = jo.getString("website");
        lang = jo.getString("lang");
        page_site = jo.getString("page_site");
        CreateMemberKeyB = jo.getString("CreateMemberKeyB");
        LoginKeyB = jo.getString("LoginKeyB");
        LogoutKeyB = jo.getString("LogoutKeyB");
        CheckUsrBalanceKeyB = jo.getString("CheckUsrBalanceKeyB");
        TransferKeyB = jo.getString("TransferKeyB");
        BetRecordKeyB = jo.getString("BetRecordKeyB");
        PlayGameKeyB = jo.getString("PlayGameKeyB");
        CheckTransferKeyB = jo.getString("CheckTransferKeyB");
    }

    @Override
    public JSONObject queryBalace(TransferBaseInfo baseInfo) {
        this.init(baseInfo);
        try {
            String targetUrl = createTargetUrl(RequestTypeEnum.QUERY_BALANCE, baseInfo);
            log.info("BBIN【查询余额】请求链接=========>" + targetUrl);
            String result = super.get(targetUrl);
            log.info("BBIN【查询余额】返回结果========>" + result);
            JSONObject balanceJson = JSONObject.parseObject(result);
            if ("true".equals(balanceJson.getString("result"))) {
                JSONArray jsonArray = JSONArray.parseArray(balanceJson.getString("data"));
                balanceJson = jsonArray.getJSONObject(0);
                return BalanceResponse.queryBalaceSuccess(balanceJson.get("Balance").toString());
            } else {
                return BalanceResponse.queryBalaceFailed();
            }

        } catch (SocketTimeoutException e) {
           e.printStackTrace();
           log.error("请求读取超时.....");
            return BalanceResponse.queryBalaceFailed();
        } catch (Exception e) {
            e.printStackTrace();
            return BalanceResponse.queryBalaceFailed();
        }
    }

    @Override
    public JSONObject getLink(TransferBaseInfo baseInfo) {
        this.init(baseInfo);
        try {
            log.info("BBIN【获取链接】构造请求链接========>");
            String targetUrl = createTargetUrl(RequestTypeEnum.GET_LINK, baseInfo);
            log.info("BBIN【构造跳转链接】链接=============>" + targetUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TransferResultEnum transferIn(TransferBaseInfo baseInfo) {
        this.init(baseInfo);
        try {
            String targetUrl = createTargetUrl(RequestTypeEnum.TRANSFER_IN, baseInfo);
            String result = super.get(targetUrl);
            log.info("BBIN【转入游戏】返回结果=========" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TransferResultEnum transferOut(TransferBaseInfo baseInfo) {
        this.init(baseInfo);
        try {
            String targetUrl = createTargetUrl(RequestTypeEnum.TRANSFER_OUT, baseInfo);
            String result = super.get(targetUrl);
            log.info("BBIN【转出余额】返回结果=========" + result);
            JSONObject data  = JSONObject.parseObject(result);
            if ("true".equalsIgnoreCase(data.getString("result"))
                    && "11100".equals(data.getJSONObject("data").getString("Code"))) {
                return TransferResultEnum.SUCCESS;
            } else {
                return TransferResultEnum.FAILED;
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            log.error("BBIN【转出余额】读取超时......");
            return TransferResultEnum.PROCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return TransferResultEnum.FAILED;
        }
    }

    @Override
    public JSONObject checkOrCreateAccount(TransferBaseInfo baseInfo) {
        return null;
    }

    @Override
    public JSONObject queryTransferOrder(TransferBaseInfo baseInfo) {
        return null;
    }

    private String createTargetUrl(RequestTypeEnum type, TransferBaseInfo baseInfo) throws Exception {
        String encryptKey;
        String key;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, -12);
        String todayStr = sdf.format(calendar.getTime());
        StringBuilder baseUrl = new StringBuilder();
        switch (type) {
            case QUERY_BALANCE:
                tempKey = website + baseInfo.getAg_username() + CheckUsrBalanceKeyB + todayStr;
                encryptKey = MD5Utils.md5toUpCase_32Bit(tempKey);
                key = "dsfredfsc" + encryptKey.toLowerCase() + "hdewsj";
                baseUrl.append(URL).append("CheckUsrBalance?website=").append(website)
                        .append("&username=").append(baseInfo.getAg_username())
                        .append("&uppername=").append(uppername)
                        .append("&key=").append(key);
                break;
            case TRANSFER_IN:
                tempKey = website + baseInfo.getAg_username() + baseInfo.getBillno() + TransferKeyB + todayStr;
                encryptKey = MD5Utils.md5toUpCase_32Bit(tempKey);
                key = "ds" + encryptKey.toLowerCase() + "hjedsxc";
                baseUrl.append(URL).append("Transfer?website=").append(website)
                        .append("&username=").append(baseInfo.getAg_username())
                        .append("&uppername=").append(uppername)
                        .append("&remitno=").append(baseInfo.getBillno())
                        .append("&action=").append("IN")
                        .append("&remit=").append(baseInfo.getCredit())
                        .append("&key=").append(key);
                break;
            case TRANSFER_OUT:
                tempKey = website + baseInfo.getAg_username() + baseInfo.getBillno() + TransferKeyB + todayStr;
                encryptKey = MD5Utils.md5toUpCase_32Bit(tempKey);
                key = "ds" + encryptKey.toLowerCase() + "hjedsxc";
                baseUrl.append(URL).append("Transfer?website=").append(website)
                        .append("&username=").append(baseInfo.getAg_username())
                        .append("&uppername=").append(uppername)
                        .append("&remitno=").append(baseInfo.getBillno())
                        .append("&action=").append("OUT")
                        .append("&remit=").append(baseInfo.getCredit())
                        .append("&key=").append(key);
                break;
            case GET_LINK:
                tempKey = website + baseInfo.getAg_username() + PlayGameKeyB + todayStr;
                encryptKey = MD5Utils.md5toUpCase_32Bit(tempKey);
                key = "dsfredf" + encryptKey.toLowerCase() + "w";
                baseUrl.append(gameUrl).append("PlayGame?websit=").append(website)
                        .append("&username=").append(baseInfo.getAg_username())
                        .append("&gamekind").append(5)
                        .append("&gametype=").append(baseInfo.getGameId())
                        .append("&lang").append(lang)
                        .append("&key=").append(key);
                break;
            case CHECK_OR_CREATE:
                tempKey = website + baseInfo.getAg_username() + CreateMemberKeyB + todayStr;
                encryptKey = MD5Utils.md5toUpCase_32Bit(tempKey);
                key = "dsfre" + encryptKey.toLowerCase() + "hj";
                baseUrl.append(URL).append("CreateMember?website=").append(website)
                        .append("&username=").append(baseInfo.getAg_username())
                        .append("&uppername=").append(uppername)
                        .append("&key=").append(key);
                break;
            case CONFIRM_TRANSFER:
                tempKey = website + CheckTransferKeyB + todayStr;
                encryptKey = MD5Utils.md5toUpCase_32Bit(tempKey);
                key = "dsxad" + encryptKey.toLowerCase() + "weka";
                baseUrl.append(URL).append("CheckTransfer?website=").append(website)
                        .append("&transid=").append(baseInfo.getBillno())
                        .append("&key=").append(key);
                break;
            case QUERY_ORDER:
                break;
        }
        return baseUrl.toString();
    }

    public static void main(String[] args) {
        BBINGameServiceImpl service = new BBINGameServiceImpl();
        JSONObject config = JSONObject.parseObject("{\n" +
                "\"URL\":\"http://linkapi.bbinauth.net/app/WebService/JSON/display.php/\",\n" +
                "\"gameUrl\":\"http://888.bbinauth.net/app/WebService/JSON/display.php/\",\n" +
                "\"uppername\":\"dbettest\",\n" +
                "\"website\":\"BETTEST\",\n" +
                "\"lang\":\"zh-cn\",\n" +
                "\"page_site\":\"live\",\n" +
                "\"CreateMemberKeyB\":\"fA8eCa090\",\n" +
                "\"LoginKeyB\":\"BaD4044\",\n" +
                "\"LogoutKeyB\":\"92F8E40\",\n" +
                "\"CheckUsrBalanceKeyB\":\"0c4B2F30d\",\n" +
                "\"TransferKeyB\":\"Q38b15GE82\",\n" +
                "\"BetRecordKeyB\":\"1E23aDb1Ec\",\n" +
                "\"PlayGameKeyB\":\"4c7F65Df9\",\n" +
                "\"CheckTransferKeyB\":\"Dc4C56a83\",\"isTest\":\"1\"}");
        TransferBaseInfo baseInfo = new TransferBaseInfo();
        baseInfo.setConfig(config);
        baseInfo.setAg_username("xpjjacky");
        baseInfo.setBillno(System.currentTimeMillis() + "1234");
        baseInfo.setCredit("10");
        System.out.println(service.transferOut(baseInfo));
    }
}
