package com.cn.tianxia.admin.domain.txdata;


import com.cn.tianxia.admin.project.txdata.CagentLuckyDrawDetail;

public interface CagentLuckyDrawDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentLuckyDrawDetail record);

    int insertSelective(CagentLuckyDrawDetail record);

    CagentLuckyDrawDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentLuckyDrawDetail record);

    int updateByPrimaryKey(CagentLuckyDrawDetail record);
}