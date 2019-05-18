package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.PlatformConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlatformConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatformConfig record);

    int insertSelective(PlatformConfig record);

    PlatformConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformConfig record);

    int updateByPrimaryKey(PlatformConfig record);

    List<PlatformConfig> findAll();

    PlatformConfig selectByPlatformKey(@Param("platformKey") String platformKey);

    /**
     * 获取游戏平台管理列表
     * @return
     */
    List<PlatformConfig> findAllUsePage(Pager<PlatformConfig> pager);

    /**
     * 获取游戏平台管理总条数
     * @return
     */
    int getTotalCount();

}