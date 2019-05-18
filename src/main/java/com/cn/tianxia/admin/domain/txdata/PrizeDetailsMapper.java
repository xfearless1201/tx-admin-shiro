package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.PrizeDetails;

import java.util.List;

public interface PrizeDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrizeDetails record);

    int insertSelective(PrizeDetails record);

    PrizeDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeDetails record);

    int updateByPrimaryKey(PrizeDetails record);


    List<PrizeDetails> selectAllByPage(Pager pager);

    int selectTotalCount(Pager pager);
}