package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
    
    /**
     * 
     * @Description 分页查询部门组织机构列表
     * @param pager
     * @return
     */
    List<Organization> findAllByPage(Pager<Organization> pager);
    
    /**
     * 
     * @Description 统计部门组织机构总条数
     * @param pager
     * @return
     */
    int getOrganizationTotalCounts(Pager<Organization> pager);
}