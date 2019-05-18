package com.cn.tianxia.admin.service.txdata.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentMapper;
import com.cn.tianxia.admin.domain.txdata.UserTypeMapper;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.project.txdata.UserType;
import com.cn.tianxia.admin.service.txdata.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {

	// 日志
	private static final Logger logger = LoggerFactory.getLogger(UserTypeServiceImpl.class);

	@Autowired
	private UserTypeMapper userTypeMapper;

	/**
	 * 平台商
	 */
	@Autowired
	private CagentMapper cagentMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(UserType record) {
		return userTypeMapper.insertSelective(record);
	}

	@Override
	public UserType selectByPrimaryKey(Integer id) {
		return userTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserType record) {
		return userTypeMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 根据cid 查询出默认分层
	 */
	@Override
	public Integer queryDefault(Integer cid) {
		return userTypeMapper.queryDefault(cid);
	}

	/**
	 * 查询平台商所属分层
	 */
	@Override
	public UserType obtainUserType(Map<String, String> params) throws BusinessException {

		/**
		 * 根据平台ID 查询平台商
		 */
		Cagent cagent = cagentMapper.selectByName(params.get("cagent") + "");
		if (null == cagent) {
			logger.error("获取平台商异常");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_CAGENTID_ERROR);
		}
		UserType usertype = userTypeMapper.obtainUserType(cagent.getId());

		return usertype;
	}

}
