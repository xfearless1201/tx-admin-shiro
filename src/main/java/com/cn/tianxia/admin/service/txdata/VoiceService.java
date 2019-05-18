package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.Voice;

import java.util.Map;

public interface VoiceService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Voice record);

    Voice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Voice record);

    /**
     * 获取声音管理列表
     * @param params
     * @return
     * @throws Exception
     */
    Pager<Voice> getAllVoice(Map<String,String> params) throws Exception;
}
