package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.PlatformStatusMapper;
import com.cn.tianxia.admin.project.txdata.PlatformStatus;
import com.cn.tianxia.admin.service.txdata.PlatformStatusService;

@Service
public class PlatformStatusServiceImpl implements PlatformStatusService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PlatformStatusServiceImpl.class);
    
    @Autowired
    private PlatformStatusMapper platformStatusMapper;
    
    @Override
    public int delete(Integer id) {
        return platformStatusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(PlatformStatus record) {
        return platformStatusMapper.insertSelective(record);
    }
    /**
     * 
     * @Description 查看单条游戏平台状态信息
     * @return
     */
    @Override
    public PlatformStatus info(Integer id) {
        return platformStatusMapper.selectByPrimaryKey(id);
    }
    /**
     * 
     * @Description 修改单条游戏平台状态信息
     * @return
     */
    @Override
    public int update(PlatformStatus record) {
        return platformStatusMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 
     * @Description 查看游戏平台状态列表信息
     * @return
     */
    @Override
    public Pager<PlatformStatus> list(Map<String, String> params) {
        Pager<PlatformStatus> pager = new Pager<PlatformStatus>();
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey("page")){
                pager.setPage(Integer.parseInt(params.remove("page")));
            }
            if(params.containsKey("limit")){
                pager.setLimit(Integer.parseInt(params.remove("limit")));
            }
        }
        pager.setParams(params);
        //根据条件查询游戏平台状态信息列表
        List<PlatformStatus> platformStatus = platformStatusMapper.findAllByPage(pager);
        //根据条件查询游戏平台状态信息总条数
        int totalCounts = platformStatusMapper.getPlatformStatusTotalCounts(pager);
        //总条数
        Pager<PlatformStatus> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(platformStatus);
        return result;
    }

}
