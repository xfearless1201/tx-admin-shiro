package com.cn.tianxia.admin.service.ftpdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.ftpdata.AgHsrMapper;
import com.cn.tianxia.admin.project.ftpdata.AgHsr;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.service.ftpdata.AGBYService;

@Service
public class AGBYServiceImpl implements AGBYService {

    @Autowired
    private AgHsrMapper agHsrMapper;
    
    Logger logger = LoggerFactory.getLogger(AGBYServiceImpl.class);

    @Override
    public Pager<AgHsr> transFormDataToPager(FormData data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pager<AgHsr> list(Pager<AgHsr> pager) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pager<AgHsr> listRecordByRealName(Pager<AgHsr> pager) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pager<AgHsr> listRecordBytopUidName(Pager<AgHsr> pager) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pager<AgHsr> listRecordByUserTypeName(Pager<AgHsr> pager) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pager<AgHsr> listRecordByAgUserName(Pager<AgHsr> pager) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pager<AgHsr> handleRecordList(List<AgHsr> agBrList, Pager<AgHsr> pager) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pager<AgHsr> doCountSum(List<Map<String, Object>> countResult, List<AgHsr> agBrList, Pager<AgHsr> pager) {
        // TODO Auto-generated method stub
        return null;
    }


}
