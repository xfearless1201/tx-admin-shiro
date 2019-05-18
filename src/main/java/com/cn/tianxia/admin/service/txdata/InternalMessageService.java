package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.project.txdata.InternalMessage;

public interface InternalMessageService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(InternalMessage record);

    InternalMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InternalMessage record);

    /**
     * 
     * @Description (发送站内信)
     * @param params
     */
	void sendMessage(Map<String, String> params) throws Exception;

}
