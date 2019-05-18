package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.project.txdata.DicData;

public interface DicDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DicData record);

    int insertSelective(DicData record);

    DicData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DicData record);

    int updateByPrimaryKey(DicData record);

    /**
     * 
     * @Description (查询数据字典)
     * @return
     */
	List<DicData> selectDicData();

	/**
	 * 
	 * @Description (根据游戏type获取 单条数据)
	 * @param gametype
	 * @return
	 */
	DicData selectByCode(String gametype);
}