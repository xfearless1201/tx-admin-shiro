package com.cn.tianxia.admin.domain.txdata;

import java.util.List;
import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserMember;
import com.cn.tianxia.admin.project.txdata.UserMemberTs;
import com.cn.tianxia.admin.vo.txdata.AddUserMemberVO;
import com.cn.tianxia.admin.vo.txdata.DisabledEntityVO;
import com.cn.tianxia.admin.vo.txdata.EditTopUidVO;
import com.cn.tianxia.admin.vo.txdata.EditUserMemberVO;
import com.cn.tianxia.admin.vo.txdata.EditUserTypeVO;
import com.cn.tianxia.admin.vo.txdata.UserMemberTsVO;
import com.cn.tianxia.admin.vo.txdata.UserMemberVO;

public interface UserMemberMapper {
	int deleteByPrimaryKey(Integer uid);

	int insert(UserMember record);

	UserMember selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(AddUserMemberVO addUserMemberVO);

	int insertSelective(UserMember record);

	int updateByPrimaryKey(UserMember record);

	/**
	 * 
	 * @Description (查询会员)
	 * @param pager
	 * @return
	 */
	List<UserMember> memberInquiry(Pager<UserMemberVO> pager);

	/**
	 * 
	 * @Description (汇总)
	 * @param pager
	 * @return
	 */
	int memberInquiryCount(Pager<UserMemberVO> pager);

	/**
	 * 
	 * @Description (查询账号是否存在)
	 * @param addUserMemberVO
	 * @return
	 */
	int ismemberAccount(AddUserMemberVO addUserMemberVO);

	/**
	 * 
	 * @Description (新增)
	 * @param record
	 * @return
	 */
	int addUserMember(AddUserMemberVO record);

	/**
	 * 
	 * @Description (根据uid查询会员单条记录)
	 * @param params
	 * @return
	 */
	UserMember editPage(Map<String, String> params);

	/**
	 * 
	 * @Description (编辑会员)
	 * @param editUserMemberVO
	 * @return
	 */
	int editUserMember(EditUserMemberVO editUserMemberVO);

	/**
	 * 
	 * @param disabledEntityVO
	 * @Description (停用/启用)
	 * @param disabledEntityVO
	 */
	void disabledEntity(DisabledEntityVO disabledEntityVO);

	/**
	 * 
	 * @Description (修改代理商)
	 * @param editTopUidVO
	 */
	void editTopUidName(EditTopUidVO editTopUidVO);

	/**
	 * 
	 * @Description (修改会员层级)
	 * @param editUserType
	 */
	void editUserType(EditUserTypeVO editUserType);

	/**
	 * 
	 * @Description (查询会员返水)
	 * @param parseInt
	 * @return
	 */
	List<UserMemberTs> userMemberTs(UserMemberTsVO userMemberTsVo);

}