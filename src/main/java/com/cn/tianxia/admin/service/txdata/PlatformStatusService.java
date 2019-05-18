package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.PlatformStatus;

public interface PlatformStatusService {

    int delete(Integer id);

    int add(PlatformStatus record);

    PlatformStatus info(Integer id);

    int update(PlatformStatus record);

    Pager<PlatformStatus> list(Map<String, String> params);
}
