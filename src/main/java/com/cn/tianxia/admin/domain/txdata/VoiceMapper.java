package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.Voice;

import java.util.List;

public interface VoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Voice record);

    int insertSelective(Voice record);

    Voice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Voice record);

    int updateByPrimaryKey(Voice record);

    /**
     * 获取声音管理列表
     * @return
     */
    List<Voice> getAllVoice(Pager<Voice> pager);

    /**
     * 获取声音总条数
     * @param pager
     * @return
     */
    int getTotalCount(Pager<Voice> pager);
}