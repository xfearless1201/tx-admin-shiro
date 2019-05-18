package com.cn.tianxia.admin.service.txdata;

import java.util.List;

import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.project.txdata.Resource;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.project.txdata.SysUser;

public interface ShiroUserService {

    public SysUser selectByLoginName(String loginName);
    
    Role selectByUserId(Long userId);
    
    List<Resource> getResourcesByUserId(Long userId);
    
    Cagent selectCagentByCid(Integer cid);
}
