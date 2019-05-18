package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.SigninRecord;

import java.util.Map;

public interface SigninRecordService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(SigninRecord record);

    SigninRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SigninRecord record);

    Pager<SigninRecord> list(Map<String,String> params);
}
