package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentOnlinememMapper;
import com.cn.tianxia.admin.project.txdata.CagentOnlinemem;
import com.cn.tianxia.admin.service.txdata.CagentOnlinememService;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName CagentOnlinememServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:44:18
 * @version 1.0.0
 */
@Service
public class CagentOnlinememServiceImpl implements CagentOnlinememService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentOnlinememServiceImpl.class);
    
    @Autowired
    private CagentOnlinememMapper cagentOnlinememMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentOnlinememMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentOnlinemem record) {
        return cagentOnlinememMapper.insertSelective(record);
    }

    @Override
    public CagentOnlinemem selectByPrimaryKey(Integer id) {
        return cagentOnlinememMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentOnlinemem record) {
        return cagentOnlinememMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<CagentOnlinemem> getAllOnlinemem(Map<String, String> params) throws Exception {
        logger.info("查询线上会员配置参数：{}",params);
        Pager<CagentOnlinemem> pager = new Pager<>();
        if(!CollectionUtils.isEmpty(params)) {
            if (params.containsKey(Constant.PAGE_FILED)) {
                pager.setPage(Integer.parseInt(params.remove(Constant.PAGE_FILED)));
            }
            if (params.containsKey(Constant.LIMIT_FILED)) {
                pager.setLimit(Integer.parseInt(params.remove(Constant.LIMIT_FILED)));
            }
            if (params.containsKey(Constant.SORT_FIELD) && params.containsKey(Constant.SORT_RULE_FILED)) {
                if (StringUtils.isBlank(params.get(Constant.SORT_FIELD))) {
                    params.remove(Constant.SORT_FIELD);
                }
                if (StringUtils.isBlank(params.get(Constant.SORT_RULE_FILED))) {
                    params.remove(Constant.SORT_RULE_FILED);
                }
            }
        }
        pager.setParams(params);
        List<CagentOnlinemem> allOnlinemems = cagentOnlinememMapper.getAllOnlinemem(pager);
        int totalCount = cagentOnlinememMapper.getTotalCount();
        Pager<CagentOnlinemem> result = new Pager<>(totalCount,pager.getPage(),pager.getLimit());
        result.setList(allOnlinemems);
        return result;
    }

}
