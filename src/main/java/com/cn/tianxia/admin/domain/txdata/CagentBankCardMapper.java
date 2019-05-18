package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentBankCard;

public interface CagentBankCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentBankCard record);

    int insertSelective(CagentBankCard record);

    CagentBankCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentBankCard record);

    int updateByPrimaryKey(CagentBankCard record);

    List<CagentBankCard> findAllByPage(Pager<CagentBankCard> pager);

    int getCagentBankCardTotalCounts(Pager<CagentBankCard> pager);
}