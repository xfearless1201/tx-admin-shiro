package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.PlatWithdrawal;

public interface PlatWithdrawalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatWithdrawal record);

    int insertSelective(PlatWithdrawal record);

    PlatWithdrawal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatWithdrawal record);

    int updateByPrimaryKey(PlatWithdrawal record);
    
    //查询总数据
    List<PlatWithdrawal> findAllByPage(Pager<PlatWithdrawal> pager);
    //根据条件查询数据总条数
    int getPlatWithdrawalTotalCounts(Pager<PlatWithdrawal> pager);

    /**
     * 
     * @Description (根据CID查询平台商配置)
     * @param parseInt
     * @return
     */
	PlatWithdrawal selectByCid(int parseInt);
}