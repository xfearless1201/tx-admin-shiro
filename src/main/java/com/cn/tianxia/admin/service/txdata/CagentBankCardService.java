package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentBankCard;

public interface CagentBankCardService {

    int deleteByPrimaryKey(Integer id);

    int add(CagentBankCard record);

    CagentBankCard info(Integer id);

    int update(CagentBankCard record);

    Pager<CagentBankCard> list(Map<String,String> params);
}
