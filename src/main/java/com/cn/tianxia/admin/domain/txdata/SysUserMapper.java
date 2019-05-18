package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectByLoginName(String loginName);
    
    List<SysUser> findAllByPage(Pager<SysUser> pager);
    
    int getRoleTotalCounts(Pager<SysUser> pager);
    
    SysUser selectByPhone(String phone);

    Integer updateWelletTransferOut(@Param("uid") String uid, @Param("money") Double money);

    Integer updateWelletTransferIn(@Param("uid") String uid, @Param("money") Double money);

    /**
     * 
     * @Description (根据平台ID获取 平台商所属代理)
     * @param id
     * @return
     */
	SysUser selectByTopUidName(@Param("id") Integer id);
}