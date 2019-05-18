package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentVoiceMapper;
import com.cn.tianxia.admin.project.txdata.CagentVoice;
import com.cn.tianxia.admin.service.txdata.CagentVoiceService;

@Service
public class CagentVoiceServiceImpl implements CagentVoiceService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentVoiceServiceImpl.class);
    
    @Autowired
    private CagentVoiceMapper cagentVoiceMapper;
    /**
     * 
     * @Description 删除单条声音配置信息
     * @return
     */
    @Override
    public int delete(Integer id) {
        return cagentVoiceMapper.deleteByPrimaryKey(id);
    }
    /**
     * 
     * @Description 添加单条声音配置信息
     * @return
     */
    @Override
    public int add(CagentVoice record) {
        return cagentVoiceMapper.insertSelective(record);
    }
    /**
     * 
     * @Description 查看单条声音配置信息
     * @return
     */
    @Override
    public CagentVoice info(Integer id) {
        return cagentVoiceMapper.selectByPrimaryKey(id);
    }
    /**
     * 
     * @Description 修改单条声音配置信息
     * @return
     */
    @Override
    public int update(CagentVoice record) {
        return cagentVoiceMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 
     * @Description 查看平台声音列表信息
     * @return
     */
    @Override
    public Pager<CagentVoice> list(Map<String, String> params) {
        Pager<CagentVoice> pager = new Pager<CagentVoice>();
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey("page")){
                pager.setPage(Integer.parseInt(params.remove("page")));
            }
            if(params.containsKey("limit")){
                pager.setLimit(Integer.parseInt(params.remove("limit")));
            }
        }
        pager.setParams(params);
        //根据条件查询声音配置列表
        List<CagentVoice> cagentVoices = cagentVoiceMapper.findAllByPage(pager);
        //根据条件查询声音配置总条数
        int totalCounts = cagentVoiceMapper.getCagentVoiceTotalCounts(pager);
        //总条数
        Pager<CagentVoice> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(cagentVoices);
        return result;
    }
}
