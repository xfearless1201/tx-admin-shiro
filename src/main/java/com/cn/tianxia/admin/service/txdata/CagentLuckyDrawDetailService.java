package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentLuckyDrawDetail;

/**
 * @Auther: zed
 * @Date: 2019/4/30 15:45
 * @Description:
 */
public interface CagentLuckyDrawDetailService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentLuckyDrawDetail record);

    CagentLuckyDrawDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentLuckyDrawDetail record);

}
