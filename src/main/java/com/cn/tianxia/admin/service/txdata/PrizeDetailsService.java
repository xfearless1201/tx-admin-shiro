package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.PrizeDetails;

import java.util.Map;

public interface PrizeDetailsService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PrizeDetails record);

    PrizeDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeDetails record);

    Pager<PrizeDetails> list(Map<String,String> params);
}
