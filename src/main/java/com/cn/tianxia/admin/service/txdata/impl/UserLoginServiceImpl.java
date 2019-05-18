package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.UserLoginMapper;
import com.cn.tianxia.admin.project.txdata.UserLogin;
import com.cn.tianxia.admin.service.txdata.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    
    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);
    
    @Autowired
    private UserLoginMapper userLoginMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userLoginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserLogin record) {
        return userLoginMapper.insertSelective(record);
    }

    @Override
    public UserLogin selectByPrimaryKey(Integer id) {
        return userLoginMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserLogin record) {
        return userLoginMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 查询会员登录记录
     */
//  @DataSource(Database.TXDATA_DB_SLAVE)
	@Override
	public Pager<UserLogin> selectUserLoginByUid(Map<String,String> params) throws Exception{
		
		logger.info("查询会员登录记录:{}", params.toString());
		Pager<Map<String,String>> pager = new Pager<Map<String,String>>();
		pager.setParams(params);
		
		List<UserLogin> userLogin = userLoginMapper.selectUserLoginByUid(pager);
		int userLoginCount = userLoginMapper.selectUserLoginCount(pager);
		
		Pager<UserLogin> result = new Pager<>(userLoginCount, pager.getPage(), pager.getLimit());
		result.setList(userLogin);
		return result;
	}

}
