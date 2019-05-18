package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserCard;

public interface UserCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCard record);

    int insertSelective(UserCard record);

    UserCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCard record);

    int updateByPrimaryKey(UserCard record);

    /**
     * 
     * @Description (根据会员uid 查询会员银行卡)
     * @param uid
     * @return
     */
	UserCard selectByUid(Integer uid);

	/**
	 * 
	 * @Description (根据uid修改银行卡)
	 * @param userCardObject
	 */
	void updateByUid(UserCard userCardObject);
}