package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.project.txdata.UserTreasure;
import com.cn.tianxia.admin.project.txdata.WinDetails;
import com.cn.tianxia.admin.vo.ftpdata.WinDetailsVO;
import com.cn.tianxia.admin.vo.txdata.UserMemberTsVO;

public interface UserTreasureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTreasure record);

    int insertSelective(UserTreasure record);

    UserTreasure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTreasure record);

    int updateByPrimaryKey(UserTreasure record);

    /**
     * 
     * @Description (查询会员加款)
     * @param winDeta
     * @return
     */
	List<WinDetails> userTreasureaddMoney(WinDetailsVO winDeta);

	/**
	 * 
	 * @Description (查询会员存款)
	 * @param winDeta
	 * @return
	 */
	List<WinDetails> userTreasureDeposit(WinDetailsVO winDeta);

	/**
	 * 
	 * @Description (查询会员提款记录)
	 * @param winDeta
	 * @return
	 */
	List<WinDetails> userTreasureWithdRawal(WinDetailsVO winDeta);

	/**
	 * 
	 * @Description (查询会员返水记录)
	 * @param winDeta
	 * @return
	 */
	List<WinDetails> userTreasureReturnWater(WinDetailsVO winDeta);

	/**
	 * 
	 * @Description (查询会员扣款记录)
	 * @param winDeta
	 * @return
	 */
	List<WinDetails> userTreasureDeductMoney(WinDetailsVO winDeta);

	/**
	 * 返水清零，记录资金流水日志
	 * @Description (TODO这里用一句话描述这个方法的作用)
	 * @param userMemberTsVo
	 */
	void cleanUserTsLog(UserMemberTsVO userMemberTsVo);
}