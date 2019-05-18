package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentVoice;

public interface CagentVoiceService {

    int delete(Integer id);

    int add(CagentVoice record);

    CagentVoice info(Integer id);

    int update(CagentVoice record);

    Pager<CagentVoice> list(Map<String, String> params);

}
