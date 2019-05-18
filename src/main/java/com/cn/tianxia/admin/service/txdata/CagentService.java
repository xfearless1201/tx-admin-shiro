package com.cn.tianxia.admin.service.txdata;

import java.util.List;
import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Cagent;

public interface CagentService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Cagent record);

    Cagent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cagent record);
    
    Pager<Cagent> list(Map<String,String> params)throws RRException;
    
    List<Cagent> getCagentSelectList(Integer id)throws RRException;
    
    int save(Cagent cagent) throws RRException;
    
    int disableOrEnable(Integer id,Integer status) throws RRException;
}
