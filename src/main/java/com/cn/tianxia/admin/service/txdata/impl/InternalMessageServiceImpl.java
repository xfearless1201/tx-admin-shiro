package com.cn.tianxia.admin.service.txdata.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cn.tianxia.admin.domain.txdata.InternalMessageMapper;
import com.cn.tianxia.admin.project.txdata.InternalMessage;
import com.cn.tianxia.admin.service.txdata.InternalMessageService;

@Service
public class InternalMessageServiceImpl implements InternalMessageService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(InternalMessageServiceImpl.class);
    
    @Autowired
    private InternalMessageMapper internalMessageMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return internalMessageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(InternalMessage record) {
        return internalMessageMapper.insertSelective(record);
    }

    @Override
    public InternalMessage selectByPrimaryKey(Integer id) {
        return internalMessageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(InternalMessage record) {
        return internalMessageMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 发送站内信
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void sendMessage(Map<String, String> params) throws Exception{
		
		String mes[] = params.get("uids").split(",");
		List<InternalMessage> messageList = new ArrayList<InternalMessage>();
		
		Arrays.stream(mes).forEach(value ->{
			InternalMessage internalMessage = new InternalMessage();
			internalMessage.setUid(Integer.parseInt(value+""));
			internalMessage.setMessage(params.get("message"));
			internalMessage.setStatus(0+"");
			internalMessage.setAddtime(new Date());
			internalMessage.setAdduserid(Integer.parseInt(params.get("ruid")+""));
			messageList.add(internalMessage);
		});
		internalMessageMapper.insertsendMessage(messageList);
		
	}

}
