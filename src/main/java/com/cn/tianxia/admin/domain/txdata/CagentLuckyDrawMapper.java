package com.cn.tianxia.admin.domain.txdata;


import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentLuckyDraw;

import java.util.List;

public interface CagentLuckyDrawMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentLuckyDraw record);

    int insertSelective(CagentLuckyDraw record);

    CagentLuckyDraw selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentLuckyDraw record);

    int updateByPrimaryKey(CagentLuckyDraw record);

    List<CagentLuckyDraw> selectAllByPage(Pager pager);

    int selectTotalCount(Pager pager);
}