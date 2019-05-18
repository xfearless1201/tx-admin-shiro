package com.cn.tianxia.admin.web.sys;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.cn.tianxia.admin.base.shiro.ShiroUser;
import com.cn.tianxia.admin.base.shiro.ShiroUtils;
import com.cn.tianxia.admin.common.RedisKeyConstant;
import com.cn.tianxia.admin.utils.JsonWebTokenUtil;
import com.cn.tianxia.admin.utils.RedisUtils;
import com.cn.tianxia.admin.utils.SpringContextUtils;

/**
 * @ClassName BaseController
 * @Description 父类公共组建给子类继承
 * @author Hardy
 * @Date 2019年4月17日 下午9:01:54
 * @version 1.0.0
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected ShiroUser getUser() {
        ShiroUser user = new ShiroUser();
        RedisUtils redisUtils = (RedisUtils) SpringContextUtils.getBean("redisUtils");
        // 用户相关信息
        String payload = (String) ShiroUtils.getSubject().getPrincipal();
        Map<String, Object> payloadMap = JsonWebTokenUtil.readValue(payload.substring(4));
        // 用户信息
        String username = (String) payloadMap.get("sub");
        // 从缓存中获取用户的信息
        String key = RedisKeyConstant.ADMIN_USER_KEY + username;
        Map<String, String> usermap = redisUtils.get(key, Map.class);
        if (!CollectionUtils.isEmpty(usermap)) {
            user.setId(Long.parseLong(usermap.get("uid")));
            user.setCid(Integer.parseInt(usermap.get("cid")));
            user.setRid(Long.parseLong(usermap.get("rid")));
            user.setUserType(Byte.parseByte(usermap.get("usertype")));
            user.setUsername(usermap.get("username"));
        }
        return user;
    }

    protected Long getUserId() {
        return getUser().getId();// 用户ID
    }

    protected String getUsername() {
        return getUser().getUsername();// 获取登录账号
    }

    // 平台ID
    protected Integer getCid() {
        return getUser().getCid();
    }

    // 用户类型 0 （管理员,平台商） 1 （一级代理） 2（二级代理）
    protected Integer getType() {
        return getUser().getType();
    }

    public boolean isAdmin() {
        return getUser().getUserType() == 0;
    }

}
