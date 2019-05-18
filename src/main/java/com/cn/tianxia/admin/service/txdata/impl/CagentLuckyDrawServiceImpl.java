package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentLuckyDrawMapper;
import com.cn.tianxia.admin.project.txdata.CagentLuckyDraw;
import com.cn.tianxia.admin.service.txdata.CagentLuckyDrawService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/30 15:47
 * @Description:
 */
@Service
@Slf4j
public class CagentLuckyDrawServiceImpl implements CagentLuckyDrawService {

    @Autowired
    private CagentLuckyDrawMapper cagentLuckyDrawMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insertSelective(CagentLuckyDraw record) {
        return 0;
    }

    @Override
    public CagentLuckyDraw selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CagentLuckyDraw record) {
        return 0;
    }

    @Override
    public Pager<CagentLuckyDraw> list(Map<String, String> params) {
        Pager<CagentLuckyDraw> pager = new Pager<>(params);
        List<CagentLuckyDraw> list = cagentLuckyDrawMapper.selectAllByPage(pager);
        int count = cagentLuckyDrawMapper.selectTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }
}
