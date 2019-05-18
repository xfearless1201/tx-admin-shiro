package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.project.txdata.InternalMessage;

public interface InternalMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InternalMessage record);

    int insertSelective(InternalMessage record);

    InternalMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InternalMessage record);

    int updateByPrimaryKey(InternalMessage record);

    /**
     * 
     * @Description (批量插入站内信)
     * @param messageList
     */
	void insertsendMessage(List<InternalMessage> messageList);
}