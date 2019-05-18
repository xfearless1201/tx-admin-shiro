package com.cn.tianxia.admin.base.shiro.filter;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.tianxia.admin.utils.RedisUtils;

@Component
public class ShiroFilterChainManager {

    @Autowired
    private RedisUtils redisUtils;
    
    public Map<String,Filter> initGetFilters() {
        Map<String,Filter> filters = new LinkedHashMap<>();
        PasswordFilter passwordFilter = new PasswordFilter(redisUtils);
        filters.put("auth",passwordFilter);
        JwtFilter jwtFilter = new JwtFilter(redisUtils);
        filters.put("jwt",jwtFilter);
        return filters;
    }
}
