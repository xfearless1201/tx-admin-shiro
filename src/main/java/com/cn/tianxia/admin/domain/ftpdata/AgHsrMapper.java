package com.cn.tianxia.admin.domain.ftpdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.ftpdata.AgHsr;
import com.cn.tianxia.admin.project.ftpdata.FormData;

public interface AgHsrMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(AgHsr record);

    int insertSelective(AgHsr record);

    AgHsr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AgHsr record);

    int updateByPrimaryKey(AgHsr record);

    /**
     * 
     * @Description (查询ag捕鱼注单)
     * @param pager
     * @return
     */
    @SuppressWarnings("hiding")
    <AgHsr> List<AgHsr> findAllByPage(FormData data);
}