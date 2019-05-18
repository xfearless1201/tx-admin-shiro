package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentGamePercentageMapper;
import com.cn.tianxia.admin.project.txdata.CagentGamePercentage;
import com.cn.tianxia.admin.service.txdata.CagentGamePercentageService;

@Service
public class CagentGamePercentageServiceImpl implements CagentGamePercentageService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentGamePercentageServiceImpl.class);
    
    @Autowired
    private CagentGamePercentageMapper cagentGamePercentageMapper;
    /**
     * 
     * @Description 删除数据占比配置信息
     * @return
     */
    @Override
    public int delete(Integer id) {
        return cagentGamePercentageMapper.deleteByPrimaryKey(id);
    }
    /**
     * 
     * @Description 添加数据占比配置信息
     * @return
     */
    @Override
    public int add(CagentGamePercentage record) {
        return cagentGamePercentageMapper.insertSelective(record);
    }
    /**
     * 
     * @Description 查看单条数据占比配置信息
     * @return
     */
    @Override
    public CagentGamePercentage info(Integer id) {
        return cagentGamePercentageMapper.selectByPrimaryKey(id);
    }
    /**
     * 
     * @Description 修改数据占比配置信息
     * @return
     */
    @Override
    public int update(CagentGamePercentage record) {
        return cagentGamePercentageMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 
     * @Description 查看平台数据占比配置列表信息
     * @return
     */
    @Override
    public Pager<CagentGamePercentage> list(Map<String, String> params) {
        Pager<CagentGamePercentage> pager = new Pager<CagentGamePercentage>();
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey("page")){
                pager.setPage(Integer.parseInt(params.remove("page")));
            }
            if(params.containsKey("limit")){
                pager.setLimit(Integer.parseInt(params.remove("limit")));
            }
        }
        pager.setParams(params);
        //根据条件查询平台数据配置列表
        List<CagentGamePercentage> cagentGamePercentages = cagentGamePercentageMapper.findAllByPage(pager);
        //根据条件查询平台数据配置总条数
        int totalCounts = cagentGamePercentageMapper.getCagentGameTotalCounts(pager);
        //总条数
        Pager<CagentGamePercentage> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(cagentGamePercentages);
        return result;
    }

}
