package com.cn.tianxia.admin.service.txdata;

import java.util.List;
import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Role;

public interface RoleService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);
    
    Role selectByUserId(Long userId);
    
    /**
     * 
     * @Description 分页查询角色信息
     * @param params
     * @return
     */
    Pager<Role> list(Map<String,String> params) throws RRException;
    
    int save(Role role)throws RRException;
    
    Role info(Long id) throws RRException;
    
    List<Role> getRoleSelectList(Pager<Role> pager) throws RRException;
    
    
    int delete(Long id) throws RRException;
}
