package com.cn.tianxia.admin.service.txdata.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.base.annotation.DataSource;
import com.cn.tianxia.admin.base.datasource.Database;
import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.RoleMapper;
import com.cn.tianxia.admin.domain.txdata.RoleResourceMapper;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.project.txdata.RoleResource;
import com.cn.tianxia.admin.service.txdata.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public Role selectByUserId(Long userId) {
        return roleMapper.selectRoleIdByUserId(userId);
    }

    @Override
    @DataSource(Database.TXDATA_DB_SLAVE)
    public Pager<Role> list(Map<String, String> params) throws RRException{
        logger.info("查询用户角色列表请求参数:{}", params.toString());
        Pager<Role> pager = new Pager<Role>();
        if (!CollectionUtils.isEmpty(params)) {
            if (params.containsKey(Constant.PAGE_FILED)) {
                pager.setPage(Integer.parseInt(params.remove(Constant.PAGE_FILED)));
            }
            if (params.containsKey(Constant.LIMIT_FILED)) {
                pager.setLimit(Integer.parseInt(params.remove(Constant.LIMIT_FILED)));
            }
            if (params.containsKey(Constant.SORT_FIELD) && params.containsKey(Constant.SORT_RULE_FILED)) {
                if (StringUtils.isBlank(params.get(Constant.SORT_FIELD)))
                    params.remove(Constant.SORT_FIELD);
                if (StringUtils.isBlank(Constant.SORT_RULE_FILED))
                    params.remove(Constant.SORT_RULE_FILED);
            }
        }
        pager.setParams(params);
        List<Role> roles = roleMapper.findAllByPage(pager);
        // 总条数
        int totalCounts = roleMapper.getRoleTotalCounts(pager);
        Pager<Role> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(roles);
        return result;
    }

    @Override
    @DataSource(Database.TXDATA_DB_SLAVE)
    public Role info(Long id) throws RRException {
        // 通过角色ID查询角色信息
        Role role = roleMapper.selectByPrimaryKey(id);
        // 通过角色ID查询角色具备的资源信息
        List<Long> resourceIds = roleResourceMapper.findAllResourceIdsByRoleId(role.getId());
        resourceIds = resourceIds.stream().distinct().collect(Collectors.toList());
        role.setMenuIdList(resourceIds);
        return role;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int save(Role role) throws RRException{
        try {
            if (role.getId() == null) {
                // 获取所有权限资源ID
                List<Long> menuIds = role.getMenuIdList();
                // 先写入权限信息
                roleMapper.insertSelective(role);
                if (!CollectionUtils.isEmpty(menuIds)) {
                    // 批量写入角色资源关联信息
                    List<RoleResource> roleResources = new ArrayList<>();
                    menuIds.stream().forEach(item -> {
                        RoleResource roleResource = new RoleResource();
                        roleResource.setResourceId(item);
                        roleResource.setRoleId(role.getId());
                        roleResources.add(roleResource);
                    });
                    // 批量写入权限资源信息
                    return roleResourceMapper.batchInsertRoleResource(roleResources);
                }
            } else {
                // 修改,通过角色ID查询角色信息
                Role r = roleMapper.selectByPrimaryKey(role.getId());
                r.setCid(role.getCid());
                r.setDescription(role.getDescription());
                r.setName(role.getName());
                r.setSeq(role.getSeq());
                r.setStatus(role.getStatus());
                // 修改角色信息
                roleMapper.updateByPrimaryKeySelective(r);
                // 写入新的权限角色资源信息
                List<Long> menuIds = role.getMenuIdList();
                if (!CollectionUtils.isEmpty(menuIds)) {
                    // 删除用户旧的角色权限关联信息
                    roleResourceMapper.batchDeleteByRoleId(r.getId());
                    // 批量写入角色资源关联信息
                    List<RoleResource> roleResources = new ArrayList<>();
                    menuIds.stream().forEach(item -> {
                        RoleResource roleResource = new RoleResource();
                        roleResource.setResourceId(item);
                        roleResource.setRoleId(role.getId());
                        roleResources.add(roleResource);
                    });
                    // 批量写入权限资源信息
                    return roleResourceMapper.batchInsertRoleResource(roleResources);
                }
            }
            throw new RRException("保存角色信息失败");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("保存角色信息异常:{}",e.getMessage());
            throw new RRException("保存角色信息异常");
        }
    }

    //获取角色选择列表
    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public List<Role> getRoleSelectList(Pager<Role> pager) throws RRException{
        List<Role> roles = roleMapper.findAllByPage(pager);
        return roles;
    }

    //删除角色信息
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
    @Override
    public int delete(Long id) throws RRException {
        //删除角色绑定的资源的关联信息
        roleResourceMapper.batchDeleteByRoleId(id);
        //删除角色信息
        return roleMapper.deleteByPrimaryKey(id);
    }
}
