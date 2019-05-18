package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentGamePercentage;

public interface CagentGamePercentageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentGamePercentage record);

    int insertSelective(CagentGamePercentage record);

    CagentGamePercentage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentGamePercentage record);

    int updateByPrimaryKey(CagentGamePercentage record);

    List<CagentGamePercentage> findAllByPage(Pager<CagentGamePercentage> pager);

    int getCagentGameTotalCounts(Pager<CagentGamePercentage> pager);
}