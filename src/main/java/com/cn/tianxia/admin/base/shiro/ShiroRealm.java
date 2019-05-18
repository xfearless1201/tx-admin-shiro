package com.cn.tianxia.admin.base.shiro;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.tianxia.admin.base.shiro.matcher.JwtMatcher;
import com.cn.tianxia.admin.base.shiro.realm.JwtRealm;
import com.cn.tianxia.admin.base.shiro.realm.PasswordRealm;
import com.cn.tianxia.admin.base.shiro.token.JwtToken;
import com.cn.tianxia.admin.base.shiro.token.PasswordToken;
import com.cn.tianxia.admin.service.txdata.ShiroUserService;


/**
 * 
 * @ClassName ShiroRealm
 * @Description realm配置类
 * @author Hardy
 * @Date 2019年4月17日 上午10:05:58
 * @version 1.0.0
 */
@Component
public class ShiroRealm {
    
    @Autowired
    private ShiroUserService shiroUserService;
    
    public List<Realm> initGetRealm() {
        List<Realm> realmList = new LinkedList<>();
        // ----- password
        PasswordRealm passwordRealm = new PasswordRealm(shiroUserService);
        passwordRealm.setAuthenticationTokenClass(PasswordToken.class);
        realmList.add(passwordRealm);
        // ----- jwt
        JwtRealm jwtRealm = new JwtRealm();
        jwtRealm.setCredentialsMatcher(new JwtMatcher());
        jwtRealm.setAuthenticationTokenClass(JwtToken.class);
        realmList.add(jwtRealm);
        return Collections.unmodifiableList(realmList);
    }
    
}
