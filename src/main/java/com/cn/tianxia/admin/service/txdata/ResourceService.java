package com.cn.tianxia.admin.service.txdata;

import java.util.List;

import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Resource;

public interface ResourceService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);
    
    List<Resource> getResourcesByUserId(Long userId)throws RRException;
    
    //根据父ID查询子资源
    List<Resource> getSubResourcesByPid(Long pid)throws RRException;
    
    List<Resource> findAllResources()throws RRException;
    
    /**
     * 
     * @Description 保存
     * @param record
     * @return
     */
    int save(Resource record)throws RRException;
    
    int disableOrEnable(Long id,Integer status) throws RRException;
    
    //通过用户ID获取系统菜单
    List<Resource> getSysNavByUserId(Long userId) throws RRException;
}
