package com.cn.tianxia.admin.common;

import com.cn.tianxia.admin.game.service.BaseGameService;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

/**
 *  SpringBeanFactoryService
 * @ClassName
 * @Description
 * @author Jacky
 * @Date 2019年5月7日 下午17:08:53
 * @version 1.0.0
 *
 */
@Component
public class SpringBeanFactoryService extends ApplicationObjectSupport {

    public BaseGameService getBean(String type){
        return  (BaseGameService) super.getApplicationContext().getBean(type);
    }
}
