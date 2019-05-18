package com.cn.tianxia.admin.game.service.implement;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.game.enums.TransferResultEnum;
import com.cn.tianxia.admin.game.service.BaseGameService;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: zed
 * @Date: 2019/5/8 20:55
 * @Description: GY game service implement
 */
@Slf4j
@Service("GY")
public class GYGameServiceImpl extends BaseGameService {



    @Override
    public void init(TransferBaseInfo baseInfo) {

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
