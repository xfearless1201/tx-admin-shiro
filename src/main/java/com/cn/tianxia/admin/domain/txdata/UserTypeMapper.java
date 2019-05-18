package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserType;

public interface UserTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserType record);

    int insertSelective(UserType record);

    UserType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserType record);

    int updateByPrimaryKey(UserType record);

    /**
     * 
     * @Description (根据cid查询出会员默认分层)
     * @param cid
     * @return
     */
	Integer queryDefault(Integer cid);

	/**
	 * 
	 * @Description (根据cid获取所属分层)
	 * @param id
	 * @return
	 */
	UserType obtainUserType(Integer id);
}