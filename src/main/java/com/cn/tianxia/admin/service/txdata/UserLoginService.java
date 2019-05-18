package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserLogin;

public interface UserLoginService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLogin record);

    /**
     * 
     * @Description (会员登录记录)
     * @param uid
     * @return
     */
	Pager<UserLogin> selectUserLoginByUid(Map<String, String> params) throws Exception;
}
