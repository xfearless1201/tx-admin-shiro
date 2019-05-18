package com.cn.tianxia.admin.base.shiro.realm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.cn.tianxia.admin.base.shiro.ShiroUser;
import com.cn.tianxia.admin.base.shiro.ShiroUtils;
import com.cn.tianxia.admin.base.shiro.token.PasswordToken;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.project.txdata.Resource;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.service.txdata.ShiroUserService;

/**
 * 
 * @ClassName PasswordRealm
 * @Description 用户登录使用
 * @author Hardy
 * @Date 2019年5月7日 下午11:36:10
 * @version 1.0.0
 */
public class PasswordRealm extends AuthorizingRealm{
    
    private ShiroUserService shiroUserService;
    
    public PasswordRealm(ShiroUserService shiroUserService) {
        this.shiroUserService = shiroUserService;
    }

    /**
     * description 此Realm只支持PasswordToken
     *
     * @return java.lang.Class<?>
     */
    @Override
    public Class<?> getAuthenticationTokenClass() {
        return PasswordToken.class;
    }
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (!(authenticationToken instanceof PasswordToken)) {
            return null;
        }
        
        if(null==authenticationToken.getPrincipal()||null==authenticationToken.getCredentials()){
            throw new UnknownAccountException();
        }
        
        //登录用户名
        String username = (String)authenticationToken.getPrincipal();
        
        SysUser user = shiroUserService.selectByLoginName(username);
        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        Cagent cagent = shiroUserService.selectCagentByCid(user.getCid());
        //判断用户状态
        if(user.getStatus() == 1){
            throw new DisabledAccountException("账号被禁用");
        }
        Set<String> urls = new HashSet<String>();
        Set<String> roles = new HashSet<>();
        //获取用户角色信息
        Role role = shiroUserService.selectByUserId(user.getId());
        roles.add(role.getId().toString());//角色ID
        //获取用户具备的资源url和角色信息
        List<Resource> resources = shiroUserService.getResourcesByUserId(user.getId());
        resources.stream().forEach(item->{
            if(StringUtils.isNotBlank(item.getPerms())){
                List<String> perms = Arrays.asList(item.getPerms().split(","));
                urls.addAll(perms);
            }
        });
        //生成签名串
        String salt = user.getSalt();//盐
        String secret = salt.substring(salt.length()-8, salt.length());
        ShiroUser shiroUser = new ShiroUser(user.getId(),user.getCid(),user.getType()
                ,username,user.getName(),role.getName(),role.getId(),urls,roles, user.getUserType(),cagent.getCagent(),secret);
        SimpleAuthenticationInfo info = 
                new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), ByteSource.Util.bytes(user.getSalt()), getName());
        return info;
    }

    /**
     * 比较方法,使用MD
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashMD5AlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashMD5Iterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
