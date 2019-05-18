package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentQrcodepayMapper;
import com.cn.tianxia.admin.project.txdata.CagentQrcodepay;
import com.cn.tianxia.admin.service.txdata.CagentQrcodepayService;

@Service
public class CagentQrcodepayServiceImpl implements CagentQrcodepayService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentQrcodepayServiceImpl.class);
    
    @Autowired
    private CagentQrcodepayMapper cagentQrcodepayMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentQrcodepayMapper.deleteByPrimaryKey(id);
    }
    /**
     * 
     * @Description 添加单条二维码配置信息
     * @return
     */
    @Override
    public int add(CagentQrcodepay record) {
        return cagentQrcodepayMapper.insertSelective(record);
    }
    /**
     * 
     * @Description 查看单条二维码配置信息
     * @return
     */
    @Override
    public CagentQrcodepay info(Integer id) {
        return cagentQrcodepayMapper.selectByPrimaryKey(id);
    }
    /**
     * 
     * @Description 修改单条二维码配置信息
     * @return
     */
    @Override
    public int update(CagentQrcodepay record) {
        return cagentQrcodepayMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 
     * @Description 查看支付二维码列表信息
     * @return
     */
    @Override
    public Pager<CagentQrcodepay> list(Map<String, String> params) {
        Pager<CagentQrcodepay> pager = new Pager<CagentQrcodepay>();
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey("page")){
                pager.setPage(Integer.parseInt(params.remove("page")));
            }
            if(params.containsKey("limit")){
                pager.setLimit(Integer.parseInt(params.remove("limit")));
            }
        }
        pager.setParams(params);
        //根据条件查询支付二维码列表
        List<CagentQrcodepay> cagentQrcodepays = cagentQrcodepayMapper.findAllByPage(pager);
        //根据条件查询支付二维码总条数
        int totalCounts = cagentQrcodepayMapper.getCagentQrcodeTotalCounts(pager);
        //总条数
        Pager<CagentQrcodepay> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(cagentQrcodepays);
        return result;
    }

}
