package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentLuckyDraw;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/30 15:43
 * @Description:
 */
public interface CagentLuckyDrawService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentLuckyDraw record);

    CagentLuckyDraw selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentLuckyDraw record);

    Pager<CagentLuckyDraw> list(Map<String,String> params);
}
