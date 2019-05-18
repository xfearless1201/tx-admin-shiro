package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentQrcodepay;

public interface CagentQrcodepayService {

    int deleteByPrimaryKey(Integer id);

    int add(CagentQrcodepay record);

    CagentQrcodepay info(Integer id);

    int update(CagentQrcodepay record);
    
    Pager<CagentQrcodepay> list(Map<String,String> params);

}
