package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.JuniorProxyFeeConfig;

public interface JuniorProxyFeeConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(JuniorProxyFeeConfig record);

    JuniorProxyFeeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JuniorProxyFeeConfig record);

}
