package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.po.GGLActivityPO;
import com.cn.tianxia.admin.project.txdata.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<GGLActivityPO> selectAllGGLByPage(Pager pager);

    int selectGGLTotalCount(Pager pager);

}