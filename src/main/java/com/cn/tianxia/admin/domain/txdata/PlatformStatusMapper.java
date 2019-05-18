package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.PlatformStatus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PlatformStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatformStatus record);

    int insertSelective(PlatformStatus record);

    PlatformStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformStatus record);

    int updateByPrimaryKey(PlatformStatus record);

    Short selectByCidAndType(@Param("cid") String cid, @Param("type") String type);

    List<PlatformStatus> findAllByPage(Pager<PlatformStatus> pager);

    int getPlatformStatusTotalCounts(Pager<PlatformStatus> pager);
}