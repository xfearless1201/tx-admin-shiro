package com.cn.tianxia.admin.game;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.game.vo.TransferBaseInfo;

/**
 * @Auther: zed
 * @Date: 2019/5/5 10:24
 * @Description: 游戏转账接口
 */
public interface GameTransferService {
    ResultResponse transferOut(TransferBaseInfo baseInfo) throws BusinessException;

    ResultResponse transferIn(TransferBaseInfo baseInfo)throws BusinessException;

    JSONObject getBalance(TransferBaseInfo baseInfo) throws Exception;

    JSONObject forwardGame(TransferBaseInfo baseInfo) throws Exception;
}
