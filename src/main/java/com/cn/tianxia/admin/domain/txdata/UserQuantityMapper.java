package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserQuantity;

public interface UserQuantityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserQuantity record);

    int insertSelective(UserQuantity record);

    UserQuantity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserQuantity record);

    int updateByPrimaryKey(UserQuantity record);

    /**
     * 
     * @Description (根据uid查询会员打码量)
     * @param uid
     * @return
     */
	UserQuantity selectByUid(Integer uid);

	/**
	 * 
	 * @Description (修改要求打码量)
	 * @param userQuantity
	 */
	void updateByUid(UserQuantity userQuantity);
}