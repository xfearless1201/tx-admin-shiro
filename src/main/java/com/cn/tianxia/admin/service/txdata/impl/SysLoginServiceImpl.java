package com.cn.tianxia.admin.service.txdata.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.base.shiro.ShiroUser;
import com.cn.tianxia.admin.base.shiro.ShiroUtils;
import com.cn.tianxia.admin.common.RedisKeyConstant;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.po.SysLoginPO;
import com.cn.tianxia.admin.service.txdata.SysLoginService;
import com.cn.tianxia.admin.utils.DESEncrypt;
import com.cn.tianxia.admin.utils.JsonWebTokenUtil;
import com.cn.tianxia.admin.utils.RedisUtils;

import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SysLoginServiceImpl implements SysLoginService {
    
    //日志
    private static final Logger logger = LoggerFactory.getLogger(SysLoginServiceImpl.class);

    @Autowired
    private RedisUtils redisUtils;
    
    /**
     * 登录接口
     * @throws Exception 
     */
    @Override
    public ResultResponse login(String username, String password) throws Exception {
        //登录成功,将签发的JWT存储到Redis： {JWT-SESSION-{username} , jwt}
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        //生成JWT令牌,时间以秒计算,token有效刷新时间是jwt有效过期时间的2倍
        long refreshPeriodTime = 1800L;//半个小时
        //设定有效期时间为1800秒,通过 >> 位移运算获取jwt的有效时间(大约在5分钟左右) refreshPeriodTime >> 2
        String jwt = JsonWebTokenUtil.issueJWT(UUID.randomUUID().toString(),username,
                "token-server",60L, user.getRoles().toString(),user.getUrls().toString(),SignatureAlgorithm.HS512);
        //对jwt进行加密返回客服端,在header中携带的jwt令牌需要经过解密才可以进行校验
        DESEncrypt desEncrypt = new DESEncrypt(user.getSecret());
        String authorizationToken = desEncrypt.encrypt(jwt);
        //存入缓存
        redisUtils.set(RedisKeyConstant.JWT_SESSION_KEY+user.getUsername(),jwt,refreshPeriodTime);
        Map<String,String> usermap = new HashMap<>();
        usermap.put("uid", user.getId().toString());//会员ID
        usermap.put("cid", user.getCid().toString());
        usermap.put("username", user.getUsername());//登录账号
        usermap.put("secret", user.getSecret());//秘钥
        usermap.put("name", user.getName());//名称
        usermap.put("rolename", user.getRoleName());//角色名称
        usermap.put("rid", user.getRid().toString());
        usermap.put("cagent", user.getCagent());//平台编码
        usermap.put("usertype", user.getUserType().toString());//平台编码
        usermap.put("token",authorizationToken);//平台编码
        usermap.put("perems", user.getUrls().toString());
        usermap.put("roles", user.getRoles().toString());
        String key = RedisKeyConstant.ADMIN_USER_KEY+username;
        redisUtils.set(key,usermap,refreshPeriodTime);//半个小时
//        return ResultResponse.success("登录成功",new SysLoginPO(username, authorizationToken));
        return ResultResponse.success("登录成功",usermap);
    }

    /**
     * 登出接口
     */
    @Override
    public ResultResponse logout(String username){
        //删除缓存中的jwt信息
        redisUtils.delete(RedisKeyConstant.JWT_SESSION_KEY+username);
        //删除缓存中的用户信息
        redisUtils.delete(RedisKeyConstant.ADMIN_USER_KEY+username);
        //调用shiro的退出
        ShiroUtils.getSubject().logout();
        return ResultResponse.success();
    }

    
}
