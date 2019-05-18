package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.LotteryRecordMapper;
import com.cn.tianxia.admin.project.txdata.LotteryRecord;
import com.cn.tianxia.admin.service.txdata.LotteryRecordService;

import java.util.List;
import java.util.Map;

@Service
public class LotteryRecordServiceImpl implements LotteryRecordService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(LotteryRecordServiceImpl.class);

    @Autowired
    private LotteryRecordMapper lotteryRecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return lotteryRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(LotteryRecord record) {
        return lotteryRecordMapper.insertSelective(record);
    }

    @Override
    public LotteryRecord selectByPrimaryKey(Integer id) {
        return lotteryRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LotteryRecord record) {
        return lotteryRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<LotteryRecord> list(Map<String, String> params) {
        Pager<LotteryRecord> pager = new Pager<>(params);
        List<LotteryRecord> list = lotteryRecordMapper.selectAllByPage(pager);
        int count = lotteryRecordMapper.selectTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

    @Override
    public Pager<LotteryRecord> luckyDrawList(Map<String, String> params) {
        Pager<LotteryRecord> pager = new Pager<>(params);
        List<LotteryRecord> list = lotteryRecordMapper.selectLuckyDrawListByPage(pager);
        int count = lotteryRecordMapper.selectLuckyDrawListTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

    @Override
    public Pager<LotteryRecord> winningList(Map<String, String> params) {
        Pager<LotteryRecord> pager = new Pager<>(params);
        List<LotteryRecord> list = lotteryRecordMapper.selectWinningListByPage(pager);
        int count = lotteryRecordMapper.selectWinningListTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

}
