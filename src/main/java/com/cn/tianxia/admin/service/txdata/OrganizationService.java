package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Organization;

public interface OrganizationService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);
    
    Pager<Organization> list(Map<String,String> params)throws RRException;

    int save(Organization organization) throws RRException;
}
