package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserPlatformReport;

public interface UserPlatformReportService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserPlatformReport record);

    UserPlatformReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPlatformReport record);

    /**
     * 
     * @Description (根据UID查询会员各游戏平台注单汇总)
     * @param uid
     * @return
     */
	Pager<UserPlatformReport> selectByUid(Integer uid)throws Exception;
}
