package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentOnlinemem;

import java.util.Map;

public interface CagentOnlinememService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentOnlinemem record);

    CagentOnlinemem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentOnlinemem record);

    Pager<CagentOnlinemem> getAllOnlinemem(Map<String,String> params) throws Exception;
}
