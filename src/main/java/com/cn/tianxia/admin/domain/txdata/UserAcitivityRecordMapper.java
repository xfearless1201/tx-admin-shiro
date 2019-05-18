package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserAcitivityRecord;

import java.util.List;

public interface UserAcitivityRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAcitivityRecord record);

    int insertSelective(UserAcitivityRecord record);

    UserAcitivityRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAcitivityRecord record);

    int updateByPrimaryKey(UserAcitivityRecord record);


    List<UserAcitivityRecord> selectAllByPage(Pager pager);

    int selectTotalCount(Pager pager);
}