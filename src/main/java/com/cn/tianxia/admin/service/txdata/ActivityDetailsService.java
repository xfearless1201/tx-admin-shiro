package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.ActivityDetails;

import java.util.Map;

/**
 * 
 * @ClassName ActivityDetailsService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:01:29
 * @version 1.0.0
 */
public interface ActivityDetailsService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ActivityDetails record);

    ActivityDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityDetails record);

    Pager<ActivityDetails> list(Map<String,String> params);
}
