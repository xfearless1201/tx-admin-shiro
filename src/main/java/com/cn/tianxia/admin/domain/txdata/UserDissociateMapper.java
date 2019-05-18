package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserDissociate;
import com.cn.tianxia.admin.vo.txdata.AddUserMemberVO;

public interface UserDissociateMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserDissociate record);

    int insertSelective(UserDissociate record);

    UserDissociate selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserDissociate record);

    int updateByPrimaryKey(UserDissociate record);

    /**
     * 
     * @Description (判断历史用户是否存在)
     * @param addUserMemberVO
     * @return
     */
	int isUserDissociateAccount(AddUserMemberVO addUserMemberVO);
}