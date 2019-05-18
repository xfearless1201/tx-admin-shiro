package com.cn.tianxia.admin.domain.txdata;

import java.util.List;
import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

    /**
     * 
     * @Description (查询会员登录记录)
     * @param pager
     * @return
     */
	List<UserLogin> selectUserLoginByUid(Pager<Map<String, String>> pager);

	/**
	 * 
	 * @Description (查询会员登录记录汇总)
	 * @param pager
	 * @return
	 */
	int selectUserLoginCount(Pager<Map<String, String>> pager);
}