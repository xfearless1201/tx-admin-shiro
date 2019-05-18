package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentWashcodeConfig;

public interface CagentWashcodeConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentWashcodeConfig record);

    CagentWashcodeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentWashcodeConfig record);

}
