package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.PlatWithdrawal;

public interface PlatWithdrawalService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PlatWithdrawal record);

    PlatWithdrawal info(Integer id);

    int update(PlatWithdrawal record);

    Pager<PlatWithdrawal> list(Map<String,String> params);
}
