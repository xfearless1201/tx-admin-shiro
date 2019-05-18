package com.cn.tianxia.admin.service.txdata.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentMapper;
import com.cn.tianxia.admin.domain.txdata.ResourceMapper;
import com.cn.tianxia.admin.domain.txdata.RoleMapper;
import com.cn.tianxia.admin.domain.txdata.RoleResourceMapper;
import com.cn.tianxia.admin.domain.txdata.SysUserMapper;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.project.txdata.Resource;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.service.txdata.ShiroUserService;

/**
 * 
 * @ClassName ShiroUserServiceImpl
 * @Description shiro接口
 * @author Hardy
 * @Date 2019年5月2日 下午4:37:06
 * @version 1.0.0
 */
@Service
public class ShiroUserServiceImpl implements ShiroUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;
    
    @Autowired
    private CagentMapper cagentMapper;
    
    @Override
    public SysUser selectByLoginName(String loginName) {
        if(StringUtils.isBlank(loginName)){
            throw new RRException("用户登录账号不能为空");
        }
        return sysUserMapper.selectByLoginName(loginName);
    }

    @Override
    public Role selectByUserId(Long userId) {
        return roleMapper.selectRoleIdByUserId(userId);
    }

    @Override
    public List<Resource> getResourcesByUserId(Long userId) {
        Set<Resource> result = new HashSet<>();
        // 1.通过用户ID查询用户的角色ID
        Role role = roleMapper.selectRoleIdByUserId(userId);
        // 2.通过角色ID查询角色具备的所有权限资源ID
        List<Long> resourceIds = roleResourceMapper.findAllResourceIdsByRoleId(role.getId());
        //获取所有得我资源信息
        List<Resource> resources = resourceMapper.findAll();
        resourceIds.stream().forEach(resourceId->{
            Resource resource = resources.stream().filter(item-> item.getId().longValue() == resourceId.longValue()).findFirst().get();
            result.add(resource);
        });
        return resources;
    }

    @Override
    public Cagent selectCagentByCid(Integer cid) {
        return cagentMapper.selectByPrimaryKey(cid);
    }

    
}
