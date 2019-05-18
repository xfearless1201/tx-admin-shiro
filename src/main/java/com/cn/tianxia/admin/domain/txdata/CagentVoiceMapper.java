package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentVoice;

public interface CagentVoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentVoice record);

    int insertSelective(CagentVoice record);

    CagentVoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentVoice record);

    int updateByPrimaryKey(CagentVoice record);

    List<CagentVoice> findAllByPage(Pager<CagentVoice> pager);

    int getCagentVoiceTotalCounts(Pager<CagentVoice> pager);
}