package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentMsgconfig;

import java.util.List;

public interface CagentMsgconfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentMsgconfig record);

    int insertSelective(CagentMsgconfig record);

    CagentMsgconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentMsgconfig record);

    int updateByPrimaryKey(CagentMsgconfig record);

    /**
     * 通过平台ID查询短信平台配置信息
     * @param pager
     * @return
     */
    List<CagentMsgconfig> findAllByCid(Pager<CagentMsgconfig> pager);

    /**
     * 获取 短信平台配置信息 总条数
     * @param pager
     * @return
     */
    int getTotalCount(Pager<CagentMsgconfig> pager);

    /**
     * 当新增的短信平台配置为启用时，把该平台商下的其它短信平台配置设置为停用，即只启用新增加的
     * @param cid
     */
    void updateStatus(Integer cid);
}