package com.cn.tianxia.admin.domain.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.AgBr;

public interface AgBrMapper extends GameRecordCommonMapper<AgBr>{
    /**
     * 
     * @Description (根据主键删除数据)
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 
     * @Description (插入ag视讯数据)
     * @param record
     * @return
     */
    int insert(AgBr record);

    /**
     * 
     * @Description (按照字段插入数据)
     * @param record
     * @return
     */
    int insertSelective(AgBr record);

    /**
     * 
     * @Description (根据id查询记录)
     * @param id
     * @return
     */
    AgBr selectByPrimaryKey(Integer id);

    /**
     * 
     * @Description (根据主键修改记录)
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AgBr record);

    /**
     * 
     * @Description (修改记录)
     * @param record
     * @return
     */
    int updateByPrimaryKey(AgBr record);
}