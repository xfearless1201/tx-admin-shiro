package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.AccountsCollect;

/**
 * 
 * @ClassName AccountsCollectService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:01:24
 * @version 1.0.0
 */
public interface AccountsCollectService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(AccountsCollect record);

    AccountsCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountsCollect record);

}
