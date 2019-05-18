package com.cn.tianxia.admin.base.shiro;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.SysUser;
public class ShiroUtils {
    
    /**  加密算法 */
    public final static String hashAlgorithmName = "SHA-256";
    
    /** MD5加密算法 **/
    public final static String hashMD5AlgorithmName = "MD5"; 
    
    /**  循环次数 */
    public final static int hashIterations = 16;
    
    public final static int hashMD5Iterations = 1;

    public static String sha256(String password, String salt) {
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }
    
    public static String MD5(String password, String salt) {
        return new SimpleHash(hashMD5AlgorithmName, password, salt, hashMD5Iterations).toString();
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static SysUser getUserEntity() {
        return (SysUser)SecurityUtils.getSubject().getPrincipal();
    }

    public static Long getUserId() {
        return getUserEntity().getId();
    }
    
    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }
    
    public static String getKaptcha(String key) {
        Object kaptcha = getSessionAttribute(key);
        if(kaptcha == null){
            throw new RRException("验证码已失效");
        }
        getSession().removeAttribute(key);
        return kaptcha.toString();
    }

    
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String salt = uuid.toString();
        System.err.println(salt);
        String password = ShiroUtils.MD5("123456", salt);
        System.err.println(password);
        
    }
}
