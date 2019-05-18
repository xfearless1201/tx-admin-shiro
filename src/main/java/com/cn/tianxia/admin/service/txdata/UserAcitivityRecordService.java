package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserAcitivityRecord;

import java.util.Map;

public interface UserAcitivityRecordService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(UserAcitivityRecord record);

    UserAcitivityRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAcitivityRecord record);

    Pager<UserAcitivityRecord> list(Map<String,String> params);

}
