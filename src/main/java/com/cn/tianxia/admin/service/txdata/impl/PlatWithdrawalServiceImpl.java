package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.PlatWithdrawalMapper;
import com.cn.tianxia.admin.project.txdata.PlatWithdrawal;
import com.cn.tianxia.admin.service.txdata.PlatWithdrawalService;

@Service
public class PlatWithdrawalServiceImpl implements PlatWithdrawalService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PlatWithdrawalServiceImpl.class);
    
    @Autowired
    private PlatWithdrawalMapper platWithdrawalMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return platWithdrawalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PlatWithdrawal record) {
        return platWithdrawalMapper.insertSelective(record);
    }
    /**
     * 
     * @Description 查看单条存取款配置信息
     * @return
     */
    @Override
    public PlatWithdrawal info(Integer id) {
        return platWithdrawalMapper.selectByPrimaryKey(id);
    }
    /**
     * 
     * @Description 修改单条存取款配置信息
     * @return
     */
    @Override
    public int update(PlatWithdrawal record) {
        return platWithdrawalMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 
     * @Description 查看存取款配置列表信息
     * @return
     */
    @Override
    public Pager<PlatWithdrawal> list(Map<String, String> params) {
        Pager<PlatWithdrawal> pager = new Pager<PlatWithdrawal>();
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey("page")){
                pager.setPage(Integer.parseInt(params.remove("page")));
            }
            if(params.containsKey("limit")){
                pager.setLimit(Integer.parseInt(params.remove("limit")));
            }
        }
        pager.setParams(params);
        //根据条件查询用户列表
        List<PlatWithdrawal> platWithdrawals = platWithdrawalMapper.findAllByPage(pager);
        //根据条件查询用户总条数
        int totalCounts = platWithdrawalMapper.getPlatWithdrawalTotalCounts(pager);
        //总条数
        Pager<PlatWithdrawal> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(platWithdrawals);
        return result;
    }

}
