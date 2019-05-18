package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.common.ResultResponse;

public interface SysLoginService {

    public ResultResponse login(String username,String password) throws Exception;
    
    public ResultResponse logout(String username);
}
