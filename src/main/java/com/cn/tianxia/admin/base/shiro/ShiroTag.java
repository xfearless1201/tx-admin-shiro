package com.cn.tianxia.admin.base.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName ShiroTag
 * @Description Shiro权限标签
 * @author Hardy
 * @Date 2019年4月17日 上午10:06:25
 * @version 1.0.0
 */
@Component
public class ShiroTag {

	/**
	 * 是否拥有该权限
	 * @param permission  权限标识
	 * @return   true：是     false：否
	 */
	public boolean hasPermission(String permission) {
		Subject subject = SecurityUtils.getSubject();
		return subject != null && subject.isPermitted(permission);
	}

}
