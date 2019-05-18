package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.ActivityDetails;

import java.util.List;

public interface ActivityDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityDetails record);

    int insertSelective(ActivityDetails record);

    ActivityDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityDetails record);

    int updateByPrimaryKey(ActivityDetails record);

    List<ActivityDetails> selectAllByPage(Pager pager);

    int selectTotalCount(Pager pager);
}