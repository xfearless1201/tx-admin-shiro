package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentWashcodeConfig;

public interface CagentWashcodeConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentWashcodeConfig record);

    int insertSelective(CagentWashcodeConfig record);

    CagentWashcodeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentWashcodeConfig record);

    int updateByPrimaryKey(CagentWashcodeConfig record);
}