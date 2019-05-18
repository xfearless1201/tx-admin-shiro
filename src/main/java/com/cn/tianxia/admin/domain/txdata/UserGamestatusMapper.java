package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserGamestatus;
import org.apache.ibatis.annotations.Param;

public interface UserGamestatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGamestatus record);

    int insertSelective(UserGamestatus record);

    UserGamestatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGamestatus record);

    int updateByPrimaryKey(UserGamestatus record);

    Integer selectUserGameStatus(@Param("uid") String uid, @Param("gametype") String gametype);
}