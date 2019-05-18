package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.po.GGLActivityPO;
import com.cn.tianxia.admin.project.txdata.Activity;

import java.util.Map;

public interface ActivityService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Activity record);

    Pager<GGLActivityPO> gglList(Map<String,String> params);
}
