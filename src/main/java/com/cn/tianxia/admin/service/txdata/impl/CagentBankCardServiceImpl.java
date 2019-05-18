package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentBankCardMapper;
import com.cn.tianxia.admin.project.txdata.CagentBankCard;
import com.cn.tianxia.admin.service.txdata.CagentBankCardService;

/**
 * 
 * @ClassName CagentBankCardServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:15:57
 * @version 1.0.0
 */
@Service
public class CagentBankCardServiceImpl implements CagentBankCardService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentBankCardServiceImpl.class);
    
    @Autowired
    private CagentBankCardMapper cagentBankCardMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentBankCardMapper.deleteByPrimaryKey(id);
    }
    /**
     * 
     * @Description 添加单条银行账户信息
     * @return
     */
    @Override
    public int add(CagentBankCard record) {
        return cagentBankCardMapper.insertSelective(record);
    }
    /**
     * 
     * @Description 查看单条银行账户信息
     * @return
     */
    @Override
    public CagentBankCard info(Integer id) {
        return cagentBankCardMapper.selectByPrimaryKey(id);
    }
    /**
     * 
     * @Description 修改单条银行账户信息
     * @return
     */
    @Override
    public int update(CagentBankCard record) {
        return cagentBankCardMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 
     * @Description 查看银行账户列表信息
     * @return
     */
    @Override
    public Pager<CagentBankCard> list(Map<String, String> params) {
        Pager<CagentBankCard> pager = new Pager<CagentBankCard>();
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
        List<CagentBankCard> cagentBankCard = cagentBankCardMapper.findAllByPage(pager);
        //根据条件查询用户总条数
        int totalCounts = cagentBankCardMapper.getCagentBankCardTotalCounts(pager);
        //总条数
        Pager<CagentBankCard> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(cagentBankCard);
        return result;
    }

}
