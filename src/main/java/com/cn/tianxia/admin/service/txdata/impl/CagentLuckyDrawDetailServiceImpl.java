package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.domain.txdata.CagentLuckyDrawDetailMapper;
import com.cn.tianxia.admin.project.txdata.CagentLuckyDrawDetail;
import com.cn.tianxia.admin.service.txdata.CagentLuckyDrawDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zed
 * @Date: 2019/4/30 15:46
 * @Description:
 */
@Service
@Slf4j
public class CagentLuckyDrawDetailServiceImpl implements CagentLuckyDrawDetailService {

    @Autowired
    private CagentLuckyDrawDetailMapper cagentLuckyDrawDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insertSelective(CagentLuckyDrawDetail record) {
        return 0;
    }

    @Override
    public CagentLuckyDrawDetail selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CagentLuckyDrawDetail record) {
        return 0;
    }
}
