package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.tianxia.admin.project.txdata.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    List<Resource> findAllByResourceIds(@Param("ids") List<Long> ids);
    
    List<Resource> findAllByPid(@Param("pid") Long pid);
    
    //查询所有资源路径
    List<Resource> findAll();
    
    //开启或禁用菜单
    int disableOrEnable(@Param("id") Long id,@Param("status") Integer status);
    
}