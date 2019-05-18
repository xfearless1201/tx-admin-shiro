package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentOnlinemem;

import java.util.List;

public interface CagentOnlinememMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentOnlinemem record);

    int insertSelective(CagentOnlinemem record);

    CagentOnlinemem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentOnlinemem record);

    int updateByPrimaryKey(CagentOnlinemem record);

    /**
     * 分页获取线上会员配置所有信息
     * @param pager
     * @return
     */
    List<CagentOnlinemem> getAllOnlinemem(Pager<CagentOnlinemem> pager);

    /**
     * 获取线上会员配置所有信息总条数
     * @return
     */
    int getTotalCount();
}