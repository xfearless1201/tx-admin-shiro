package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentGamePercentage;

public interface CagentGamePercentageService {

    int delete(Integer id);

    int add(CagentGamePercentage record);

    CagentGamePercentage info(Integer id);

    int update(CagentGamePercentage record);

    Pager<CagentGamePercentage> list(Map<String, String> params);
}
