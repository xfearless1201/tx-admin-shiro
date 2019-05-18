package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.base.annotation.DataSource;
import com.cn.tianxia.admin.base.datasource.Database;
import com.cn.tianxia.admin.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.ActivityDetailsMapper;
import com.cn.tianxia.admin.project.txdata.ActivityDetails;
import com.cn.tianxia.admin.service.txdata.ActivityDetailsService;

import java.util.List;
import java.util.Map;


/**
 * 
 * @ClassName ActivityDetailsServiceImpl
 * @Description 活动接口实现类
 * @author Hardy
 * @Date 2019年4月22日 下午3:00:49
 * @version 1.0.0
 */
@Service
public class ActivityDetailsServiceImpl implements ActivityDetailsService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ActivityDetailsServiceImpl.class);
    
    @Autowired
    private ActivityDetailsMapper activityDetailsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return activityDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ActivityDetails record) {
        return activityDetailsMapper.insertSelective(record);
    }

    @Override
    public ActivityDetails selectByPrimaryKey(Integer id) {
        return activityDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ActivityDetails record) {
        return activityDetailsMapper.updateByPrimaryKeySelective(record);
    }

    @DataSource(Database.TXDATA_DB_SLAVE)
    @Override
    public Pager<ActivityDetails> list(Map<String, String> params) {

        Pager<ActivityDetails> pager = new Pager<>(params);
        List<ActivityDetails> list = activityDetailsMapper.selectAllByPage(pager);
        int count = activityDetailsMapper.selectTotalCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }
}
