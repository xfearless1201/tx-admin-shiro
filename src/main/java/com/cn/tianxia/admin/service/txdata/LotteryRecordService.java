package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.LotteryRecord;

import java.util.Map;

public interface LotteryRecordService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(LotteryRecord record);

    LotteryRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LotteryRecord record);

    Pager<LotteryRecord> list(Map<String, String> params);

    Pager<LotteryRecord> luckyDrawList(Map<String, String> params);

    Pager<LotteryRecord> winningList(Map<String, String> params);

}
