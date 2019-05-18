package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserWalletLog;

import java.util.List;
import java.util.Map;

public interface UserWalletLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWalletLog record);

    int insertSelective(UserWalletLog record);

    UserWalletLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWalletLog record);

    int updateByPrimaryKey(UserWalletLog record);

    List<UserWalletLog> selectList(Pager pager);

    Map<String, Object> countList(Pager pager);
}