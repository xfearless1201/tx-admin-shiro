package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.ProxyFeeConfig;

public interface ProxyFeeConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ProxyFeeConfig record);

    ProxyFeeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxyFeeConfig record);
}
