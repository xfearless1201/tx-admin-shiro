package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentYsepay;

public interface CagentYsepayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentYsepay record);

    int insertSelective(CagentYsepay record);

    CagentYsepay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentYsepay record);

    int updateByPrimaryKey(CagentYsepay record);

    List<CagentYsepay> findAllByPage(Pager<CagentYsepay> pager);

    int getCagentYsepayTotalCounts(Pager<CagentYsepay> pager);
}