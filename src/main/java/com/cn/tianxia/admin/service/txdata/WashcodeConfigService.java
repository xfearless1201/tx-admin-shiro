package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.WashcodeConfig;

public interface WashcodeConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(WashcodeConfig record);

    WashcodeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WashcodeConfig record);
}
