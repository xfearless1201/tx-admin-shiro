package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentMsgconfig;

import java.util.Map;

public interface CagentMsgconfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentMsgconfig record);

    CagentMsgconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentMsgconfig record);

    /**
     *
     * @Description 通过平台ID分页短信平台配置信息
     * @param params
     * @return
     */
    Pager<CagentMsgconfig> findAllByCid(Map<String,String> params) throws Exception;

    /**
     * 添加短信平台配置信息时还需判断状态status
     * @param record
     * @return
     */
    int insertJudgeStatus(CagentMsgconfig record);

    /**
     * 添加短信平台配置信息时还需判断状态status
     * @param record
     * @return
     */
    int updateJudgeStatus(CagentMsgconfig record);


}
