package com.cn.tianxia.admin.service.txdata.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.base.annotation.DataSource;
import com.cn.tianxia.admin.base.datasource.Database;
import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.domain.txdata.ResourceMapper;
import com.cn.tianxia.admin.domain.txdata.RoleMapper;
import com.cn.tianxia.admin.domain.txdata.RoleResourceMapper;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Resource;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.service.txdata.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Resource record) {
        return resourceMapper.insertSelective(record);
    }

    @Override
    public Resource selectByPrimaryKey(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Resource record) {
        return resourceMapper.updateByPrimaryKeySelective(record);
    }

    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public List<Resource> getResourcesByUserId(Long userId) throws RRException{
        logger.info("查询用户具备的资源信息开始==============START==================");
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

    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public List<Resource> getSubResourcesByPid(Long pid) {
        return resourceMapper.findAllByPid(pid);
    }

    
    /**
     * 保存
     */
    @Override
    public int save(Resource record) throws RRException{
        if(record.getId() == null){
            //新增
            record.setCreateTime(new Date());
            record.setCreateTime(new Date());
            record.setStatus((byte)0);
            if(record.getType() == Constant.MenuType.MENU.getValue() || record.getType() == Constant.MenuType.BUTTON.getValue()){
                //如果是菜单或者按钮的时候,存入父级名称
                Resource resource = resourceMapper.selectByPrimaryKey(record.getPid());
                record.setPname(resource.getName());
            }
            //插入菜单信息
            return resourceMapper.insertSelective(record);
        }else {
            //修改,通过菜单ID查询菜单信息
            Resource resource = resourceMapper.selectByPrimaryKey(record.getId());
            if(resource == null){
                logger.info("修改菜单信息失败,菜单ID:{},查询无菜单信息",record.getId());
                throw new RRException("修改菜单信息失败");
            }
            resource.setName(record.getName());//菜单名称
            resource.setIcon(record.getIcon());//菜单图标
            resource.setIsSys(record.getIsSys());//是否为系统资源
            resource.setNicon(record.getNicon());//新图标
            resource.setNurl(record.getNurl());//新URL地址
            resource.setPerms(record.getPerms());//授权标识
            resource.setPid(record.getPid());//父级ID
            resource.setPname(record.getPname());//父级名称
            resource.setSeq(record.getSeq());//排序
            resource.setStatus(record.getStatus());//菜单状态
            resource.setType(record.getType());//菜单类型
            resource.setUrl(record.getUrl());//菜单旧URL地址
            //修改菜单信息
            return resourceMapper.updateByPrimaryKeySelective(resource);
        }
    }

    /**
     * 获取所有的资源信息
     */
    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public List<Resource> findAllResources() throws RRException{
        //查询所有的资源信息
        List<Resource> resources = resourceMapper.findAll();
        return resources;
    }
    
    /**
     * 禁用或启用资源
     */
    @Override
    public int disableOrEnable(Long id,Integer status) throws RRException {
        return resourceMapper.disableOrEnable(id, status);
    }
    
    /**
     * 通过用户ID获取系统菜单
     */
//    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public List<Resource> getSysNavByUserId(Long userId) throws RRException {
        List<Resource> resources = new ArrayList<>();
        if(userId == null){
            resources = resourceMapper.findAll();
        }else{
            resources = getResourcesByUserId(userId);
        }
        // 获取目录信息
        List<Resource> catalogs = resources.stream().filter(r -> r.getType() == Constant.MenuType.CATALOG.getValue())
                .collect(Collectors.toList());
        //目录排序
        catalogs.sort((s1,s2) -> s1.getId().intValue() - s2.getId().intValue());
        // 获取菜单信息
        List<Resource> menus = resources.stream().filter(r -> r.getType() == Constant.MenuType.MENU.getValue())
                .collect(Collectors.toList());
        // 菜单分组
        Map<Long, List<Resource>> menumap = menus.stream().collect(Collectors.groupingBy(r -> r.getPid()));
        // 组装菜单树
        catalogs.stream().forEach(r -> {
            List<Resource> submenus = menumap.get(r.getId());
            //排序
            if(!CollectionUtils.isEmpty(submenus)){
                submenus.sort((s1,s2) -> s1.getSeq() - s2.getSeq());
                r.setList(submenus);
            }
        });
        return catalogs;
    }
}
