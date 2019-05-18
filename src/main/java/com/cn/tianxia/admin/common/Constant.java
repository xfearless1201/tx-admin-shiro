package com.cn.tianxia.admin.common;

/**
 * 
 * @ClassName Constant
 * @Description 常量类
 * @author Hardy
 * @Date 2019年4月25日 下午12:18:30
 * @version 1.0.0
 */
public class Constant {
    
    //超级账号ID
    public static final String SUPER_ACCOUNT="admin";
    
    //token
    public static final String AUTHORIZATION_TOKEN = "authorization";
    
    //认证ID
    public static final String AUTHORIZATION_ID = "username";
    
    //jwt过期
    public static final String EXPIRED_JWT = "expiredJwt";
    
    //异常令牌
    public static final String ERR_JWT = "errJwt";
    
    //系统资源(系统资源不可以使用程序删除)
    public static final int SYS_RESOURCE=1;
    
    //排序字段
    public static final String SORT_FIELD="sidx";
    
    //排序规则
    public static final String SORT_RULE_FILED="order";
    
    //升序规则
    public static final String SORT_RULE_DESC="DESC";
    
    //降序规则
    public static final String SORT_RULE_ASC="ASC";
    
    //分页页码
    public static final String PAGE_FILED="page";

    //分页条数
    public static final String LIMIT_FILED="limit";
    
    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
