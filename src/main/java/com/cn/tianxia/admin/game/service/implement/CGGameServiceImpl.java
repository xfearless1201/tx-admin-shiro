package com.cn.tianxia.admin.game.service.implement;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.game.enums.RequestTypeEnum;
import com.cn.tianxia.admin.game.enums.TransferResultEnum;
import com.cn.tianxia.admin.game.service.BaseGameService;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: zed
 * @Date: 2019/5/8 11:03
 * @Description: cg game service implement
 */
@Service("CG")
@Slf4j
public class CGGameServiceImpl extends BaseGameService {

    private String apiurl;
    private String hashcode;
    private String currency;

    @Override
    public void init(TransferBaseInfo baseInfo) {
        if (null == baseInfo.getConfig()) {
            throw new BusinessException(CommonErrorEnum.GAME_CONFIG_IS_EMPTY);
        }
        JSONObject jo = baseInfo.getConfig();
        apiurl=jo.getString("apiurl");
        hashcode=jo.getString("hashcode");
        currency = jo.getString("currency");
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

    private String sendRequest(RequestTypeEnum type, TransferBaseInfo info) throws Exception {
        JSONObject data = new JSONObject();
        data.put("hashCode", hashcode);
        JSONObject params = new JSONObject();
        switch (type) {
            case QUERY_BALANCE:
                params.put("username", info.getAg_username());
                params.put("password", info.getAg_password());
                data.put("command", "GET_BALANCE");
                data.put("params", params);
                break;
            case TRANSFER_IN:
                params.put("username", info.getAg_username());
                params.put("password", info.getAg_password());
                params.put("ref", info.getBillno());
                params.put("desc", "DEPOSIT");
                params.put("amount", info.getCredit());
                data.put("command", "DEPOSIT");
                data.put("params", params);
                break;
            case TRANSFER_OUT:
                params.put("username", info.getAg_username());
                params.put("password", info.getAg_password());
                params.put("ref", info.getBillno());
                params.put("desc", "withdraw " + info.getCredit());
                params.put("amount", info.getCredit());
                data.put("command", "WITHDRAW");
                data.put("params", params);
                break;
            case QUERY_ORDER:
                params.put("ref", info.getBillno());
                data.put("command", "CHECK_REF");
                data.put("params", params);
                break;
            case CHECK_OR_CREATE:
                params.put("username", info.getAg_username());
                params.put("password", info.getAg_password());
                params.put("nickname", info.getAg_username());
                params.put("currency", currency);
                params.put("language", "CN");
                data.put("command", "LOGIN");
                data.put("params", params);
                break;
        }
        return super.postJson(apiurl, data.toString());
    }
}
