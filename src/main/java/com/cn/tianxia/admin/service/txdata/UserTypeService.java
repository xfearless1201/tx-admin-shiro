package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.project.txdata.UserType;

public interface UserTypeService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserType record);

    UserType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserType record);

    /**
     * 
     * @Description (根据CID查询出默认分层)
     * @param cid
     * @return
     */
    Integer queryDefault(Integer cid);

    /**
     * 
     * @Description (根据平台商编码获取所属分层)
     * @param params
     */
    UserType obtainUserType(Map<String, String> params) throws BusinessException;
}
