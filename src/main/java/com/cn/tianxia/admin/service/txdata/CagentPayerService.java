package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentPayer;

public interface CagentPayerService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentPayer record);

    CagentPayer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentPayer record);

}
