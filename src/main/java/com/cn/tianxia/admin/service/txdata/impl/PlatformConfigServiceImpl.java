package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PlatformConfigMapper;
import com.cn.tianxia.admin.project.txdata.PlatformConfig;
import com.cn.tianxia.admin.service.txdata.PlatformConfigService;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
public class PlatformConfigServiceImpl implements PlatformConfigService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PlatformConfigServiceImpl.class);
    
    @Autowired
    private PlatformConfigMapper platformConfigMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return platformConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PlatformConfig record) {
        return platformConfigMapper.insertSelective(record);
    }

    @Override
    public PlatformConfig selectByPrimaryKey(Integer id) {
        return platformConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PlatformConfig record) {
        return platformConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<PlatformConfig> findAllUsePage(Map<String, String> params) throws Exception {
        logger.info("查询游戏平台管理信息参数：{}",params);
        Pager<PlatformConfig> pager =new Pager<>();
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey(Constant.PAGE_FILED)){
                pager.setPage(Integer.parseInt(params.remove(Constant.PAGE_FILED)));
            }
            if(params.containsKey(Constant.LIMIT_FILED)){
                pager.setLimit(Integer.parseInt(params.remove(Constant.LIMIT_FILED)));
            }
        }
        pager.setParams(params);
        List<PlatformConfig> platformConfigs = platformConfigMapper.findAllUsePage(pager);
        int totalCount = platformConfigMapper.getTotalCount();
        Pager result = new Pager(totalCount,pager.getPage(),pager.getLimit());
        result.setList(platformConfigs);
        return result;

    }


}
