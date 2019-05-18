package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.ReserveAccount;
import com.cn.tianxia.admin.vo.txdata.AddUserMemberVO;

public interface ReserveAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReserveAccount record);

    int insertSelective(ReserveAccount record);

    ReserveAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReserveAccount record);

    int updateByPrimaryKey(ReserveAccount record);

    /**
     * 
     * @Description (判断是否为系统保留账户)
     * @param addUserMemberVO
     * @return
     */
	int isReserveAccount(AddUserMemberVO addUserMemberVO);
}