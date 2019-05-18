package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.AccountDaySum;

/**
 * 
 * @ClassName AccountDaySumService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:01:19
 * @version 1.0.0
 */
public interface AccountDaySumService {
    
    int deleteByPrimaryKey(Long id);

    int insertSelective(AccountDaySum record);

    AccountDaySum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountDaySum record);

}
