package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentStoredvalue;
import com.cn.tianxia.admin.vo.txdata.UserMemberTsVO;

public interface CagentStoredvalueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentStoredvalue record);

    int insertSelective(CagentStoredvalue record);

    CagentStoredvalue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentStoredvalue record);

    int updateByPrimaryKey(CagentStoredvalue record);

    /**
     * 
     * @Description (根据平台商ID获取平台商额度)
     * @param id
     * @return
     */
	CagentStoredvalue selectByCid(Integer id);

	/**
	 * 
	 * @Description (清零返水)
	 * @param userMemberTsVo
	 */
	void updateMakeZero(UserMemberTsVO userMemberTsVo);
}