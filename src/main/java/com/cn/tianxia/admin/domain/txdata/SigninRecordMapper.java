package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.SigninRecord;

import java.util.List;

public interface SigninRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SigninRecord record);

    int insertSelective(SigninRecord record);

    SigninRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SigninRecord record);

    int updateByPrimaryKey(SigninRecord record);


    List<SigninRecord> selectAllRecordByPage(Pager pager);

    int selectTotalCount(Pager pager);
}