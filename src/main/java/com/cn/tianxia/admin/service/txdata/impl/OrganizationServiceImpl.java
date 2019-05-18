package com.cn.tianxia.admin.service.txdata.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.OrganizationMapper;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Organization;
import com.cn.tianxia.admin.service.txdata.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Organization record) {
        return organizationMapper.insertSelective(record);
    }

    @Override
    public Organization selectByPrimaryKey(Long id) {
        return organizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Organization record) {
        return organizationMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 分页查询系统部门组织机构列表
     */
    @Override
    public Pager<Organization> list(Map<String, String> params) throws RRException {
        Pager<Organization> pager = new Pager<Organization>(0, 0);
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

            if (params.containsKey("cid")) {
                if (StringUtils.isBlank(params.get("cid")))
                    params.remove("cid");
            }
        }
        pager.setParams(params);
        // 按条件查询部门组织机构列表
        List<Organization> organizations = organizationMapper.findAllByPage(pager);
        // 统计部门组织机构总条数
        int totalCounts = organizationMapper.getOrganizationTotalCounts(pager);
        Pager<Organization> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(organizations);
        return result;
    }

    
    /**
     * 保存系统部门组织机构信息
     */
    @Override
    public int save(Organization organization) throws RRException {
        if(organization.getId() == null){
            //新增
            organization.setCreateTime(new Date());
            return organizationMapper.insertSelective(organization);
        }else{
            //编辑
            Organization o = organizationMapper.selectByPrimaryKey(organization.getId());
            if(o == null){
                logger.info("修改部门组织机构信息异常,根据ID:{}查询部门组织机构信息失败",organization.getId());
                throw new RRException("修改部门组织机构信息异常,根据ID查询部门组织机构信息失败");
            }
            BeanUtils.copyProperties(organization, o);
            return organizationMapper.updateByPrimaryKeySelective(o);
        }
    }
}
