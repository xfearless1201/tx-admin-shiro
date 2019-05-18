package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserLuckrdrawLog;

import java.util.List;

public interface UserLuckrdrawLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLuckrdrawLog record);

    int insertSelective(UserLuckrdrawLog record);

    UserLuckrdrawLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLuckrdrawLog record);

    int updateByPrimaryKey(UserLuckrdrawLog record);

    List<UserLuckrdrawLog> selectAllByPage(Pager pager);

    int selectTotalCount(Pager pager);
}