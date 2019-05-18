package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentYsepay;

public interface CagentYsepayService {

    int delete(Integer id);

    int add(CagentYsepay record);

    CagentYsepay info(Integer id);

    int update(CagentYsepay record);

    Pager<CagentYsepay> list(Map<String,String> params);
}
