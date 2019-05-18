package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.tianxia.admin.domain.txdata.PrizeDetailsMapper;
import com.cn.tianxia.admin.project.txdata.PrizeDetails;
import com.cn.tianxia.admin.service.txdata.PrizeDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PrizeDetailsServiceImpl implements PrizeDetailsService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PrizeDetailsServiceImpl.class);
    
    @Autowired
    private PrizeDetailsMapper prizeDetailsMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return prizeDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PrizeDetails record) {
        return prizeDetailsMapper.insertSelective(record);
    }

    @Override
    public PrizeDetails selectByPrimaryKey(Integer id) {
        return prizeDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PrizeDetails record) {
        return prizeDetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<PrizeDetails> list(Map<String, String> params) {
        Pager<PrizeDetails> pager = new Pager<>(params);
        List<PrizeDetails> list = prizeDetailsMapper.selectAllByPage(pager);
        int count = prizeDetailsMapper.selectTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }


}
