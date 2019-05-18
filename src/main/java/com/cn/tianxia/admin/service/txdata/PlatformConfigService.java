package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.PlatformConfig;

import java.util.Map;

public interface PlatformConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PlatformConfig record);

    PlatformConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformConfig record);

    /**
     * 分页查询获得游戏平台管理列表
     * @param params
     * @return
     */
    Pager<PlatformConfig> findAllUsePage(Map<String,String> params) throws Exception;

}
