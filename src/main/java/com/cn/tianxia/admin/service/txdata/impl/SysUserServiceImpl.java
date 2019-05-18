package com.cn.tianxia.admin.service.txdata.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.base.annotation.DataSource;
import com.cn.tianxia.admin.base.datasource.Database;
import com.cn.tianxia.admin.base.shiro.ShiroUtils;
import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentMapper;
import com.cn.tianxia.admin.domain.txdata.RoleMapper;
import com.cn.tianxia.admin.domain.txdata.SysUserMapper;
import com.cn.tianxia.admin.domain.txdata.UserRoleMapper;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.project.txdata.UserRole;
import com.cn.tianxia.admin.service.txdata.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private UserRoleMapper userRoleMapper;
    
    @Autowired
    private RoleMapper roleMapper;
    
    /**
     * 平台商
     */
    @Autowired
    private CagentMapper cagentMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public SysUser selectByPrimaryKey(Long id) {
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
        user.setPassword(null);//不显示密码
        user.setSalt(null);//不显示盐
        return user;
    }
    
    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 通过用户登录账号查询用户信息
     */
    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public SysUser selectByLoginName(String loginName) throws RRException{
        logger.info("查询用户账号为:{}的会员信息开始=============START============",loginName);
        if(StringUtils.isBlank(loginName)){
            throw new RRException("用户登录账号不能为空");
        }
        SysUser sysUser = sysUserMapper.selectByLoginName(loginName);
        return sysUser;
    }

    /**
     * 查询用户列表
     */
    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public Pager<SysUser> list(Map<String, String> params) {
        logger.info("查询用户角色列表请求参数:{}",params.toString());
        Pager<SysUser> pager = new Pager<SysUser>(0,0);
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey(Constant.PAGE_FILED)){
                pager.setPage(Integer.parseInt(params.remove(Constant.PAGE_FILED)));
            }
            if(params.containsKey(Constant.LIMIT_FILED)){
                pager.setLimit(Integer.parseInt(params.remove(Constant.LIMIT_FILED)));
            }
            
            if(params.containsKey(Constant.SORT_FIELD) && params.containsKey(Constant.SORT_RULE_FILED)){
                if(StringUtils.isBlank(params.get(Constant.SORT_FIELD))) params.remove(Constant.SORT_FIELD);
                if(StringUtils.isBlank(Constant.SORT_RULE_FILED)) params.remove(Constant.SORT_RULE_FILED);
             }
        }
        pager.setParams(params);
        //根据条件查询用户列表
        List<SysUser> users = sysUserMapper.findAllByPage(pager);
        //根据条件查询用户总条数
        int totalCounts = sysUserMapper.getRoleTotalCounts(pager);
        //总条数
        Pager<SysUser> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(users);
        return result;
    }

    /**
     * 保存用户信息
     */
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
    @Override
    public int save(SysUser user)throws Exception{
        if(user.getId() == null){//新增
            //获取用户的登录账号,判断是否已存在
            String loginName = user.getLoginName();
            SysUser sysUser = sysUserMapper.selectByLoginName(loginName);
            if(sysUser != null){
                //账号已存在
                throw new RRException("账号已存在,请重新填写");
            }
            
            //获取用户手机号码,判断手机号码是否重复
            String phone = user.getPhone();
            sysUser = sysUserMapper.selectByPhone(phone);
            if(sysUser != null){
                //手机号码已存在
                throw new RRException("手机号码已存在,请重新填写");
            }
            user.setCreateTime(new Date());//创建时间
            //生成密码盐
            UUID uuid = UUID.randomUUID();
            String salt = uuid.toString();
            String password = user.getPassword();
            //生成加密密码
            password = ShiroUtils.MD5(password, salt);
            user.setPassword(password);
            user.setSalt(salt);
            //保存用户信息
            sysUserMapper.insertSelective(user);
            //保存角色信息
            UserRole userRole = new UserRole();
            userRole.setRoleId(user.getRoleId());
            userRole.setUserId(user.getId());
            return userRoleMapper.insertSelective(userRole);
        }else{//修改
            //通过用户ID查询用户信息
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
            if(sysUser == null){
                logger.info("通过用户ID：{},查询用户信息失败",user.getId());
                throw new RRException("用户ID异常,查询用户信息失败");
            }
            //获取用户的手机号码,判断手机号码是否存在
            String phone = user.getPhone();
            if(StringUtils.isNotEmpty(phone)){
                //通过手机号码查询用户信息
                SysUser userPhone = sysUserMapper.selectByPhone(phone);
                if(userPhone != null){
                    throw new RRException("手机号码已存在,请重新填写");
                }
            }
            BeanUtils.copyProperties(user, sysUser);
            //获取待修改的密码
            String password = sysUser.getPassword();
            if(StringUtils.isNotBlank(password)){
                //生成密码盐
                UUID uuid = UUID.randomUUID();
                String salt = uuid.toString();
                password = ShiroUtils.MD5(password, salt);
                user.setPassword(password);
                user.setSalt(salt);
            }
            //修改用户信息
            sysUserMapper.updateByPrimaryKeySelective(sysUser);
            //修改角色与权限的绑定关系
            return userRoleMapper.updateByUserId(user.getId(), user.getRoleId());
        }
    }

    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public SysUser info(Long id) throws Exception {
        //通过用户ID查询用户信息
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
        if(user != null){
            //查询用户的权限
            Role role = roleMapper.selectRoleIdByUserId(id);
            user.setRoleId(role.getId());
        }
        user.setPassword(null);
        user.setSalt(null);
        return user;
    }

    /**
     * 根据平台编码cagent 查询所属代理商
     */
	@Override
	public SysUser selectByTopUidName(Map<String, String> params) throws BusinessException{
		
		/**
		 * 查询平台商数据
		 */
		Cagent cagent = cagentMapper.selectByName(params.get("cagent"));
		
		if(null == cagent){
			logger.error("获取平台商异常");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_CAGENTID_ERROR);
		}
		/**
		 * 根据平台商ID获取平台商所属一级代理
		 */
		SysUser sysUser = sysUserMapper.selectByTopUidName(cagent.getId());
		
		return sysUser;
	}
    
}
