package com.cn.tianxia.admin.service.txdata;

import java.util.List;
import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.project.txdata.UserMember;
import com.cn.tianxia.admin.project.txdata.UserMemberTs;
import com.cn.tianxia.admin.project.txdata.WinDetails;
import com.cn.tianxia.admin.vo.txdata.AddUserMemberVO;
import com.cn.tianxia.admin.vo.txdata.UserMoneyVO;

public interface UserMemberService {

	int deleteByPrimaryKey(Integer uid);

	int insertSelective(UserMember record);

	UserMember selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(AddUserMemberVO record);

	/**
	 * 
	 * @Description (平台会员管理查询)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	Pager<UserMember> memberInquiry(Map<String, String> params) throws Exception;

	/**
	 * 
	 * @Description (输赢详情查询)
	 * @param params
	 * @return
	 */
	Pager<WinDetails> selectWinDetails(Map<String, String> params) throws Exception;

	/**
	 * 
	 * @Description (输赢详情明细)
	 * @param params
	 * @return
	 */
	Pager<WinDetails> selectWinDetailsPage(Map<String, String> params) throws Exception;

	/**
	 * 
	 * @Description (添加会员)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	int addUserMember(Map<String, String> params) throws Exception;

	/**
	 * 
	 * @Description (根据uid获取会员单条数据)
	 * @param params
	 * @return
	 */
	UserMember editPage(Map<String, String> params) throws Exception;

	/**
	 * 
	 * @Description (编辑会员)
	 * @param params
	 * @return
	 */
	int editUserMember(Map<String, String> params) throws Exception;

	/**
	 * 
	 * @Description (停用启用)
	 * @param params
	 */
	void disabledEntity(Map<String, String> params) throws Exception;

	/**
	 * 
	 * @Description (手动加扣款页)
	 * @param params
	 */
	UserMoneyVO additionPage(Map<String, String> params) throws BusinessException;

	/**
	 * 
	 * @Description (手动加扣款，赠送彩金)
	 * @param params
	 */
	void addAmount(Map<String, String> params) throws BusinessException;

	/**
	 * 
	 * @Description (修改代理商)
	 * @param params
	 */
	void editTopUidName(Map<String, String> params);

	/**
	 * 
	 * @Description (修改会员层级)
	 * @param params
	 */
	void editUserType(Map<String, String> params);

	/**
	 * 
	 * @Description (会员返水)
	 * @param params
	 */
	List<UserMemberTs> userMemberTs(Map<String, String> params);

	/**
	 * 
	 * @Description (给予返水)
	 * @param params
	 */
	void confirmTs(Map<String, String> params)throws BusinessException;

	/**
	 * 
	 * @Description (返水清零)
	 * @param params
	 */
	void updateMakeZero(Map<String, String> params);


}
