package com.cn.tianxia.admin.web.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName SysPageController
 * @Description 系统页面视图接口
 * @author Hardy
 * @Date 2019年4月16日 下午5:50:40
 * @version 1.0.0
 */
@Controller
public class SysPageController extends BaseController{

    @RequestMapping(value = {"/", "index.html"})
    public String index(){
        return "index";
    }
    
    @RequestMapping("index1.html")
    public String index1(){
        return "index1";
    }

    @RequestMapping("login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("main.html")
    public String main(){
        return "main";
    }

    @RequestMapping("404.html")
    public String notFound(){
        return "404";
    }
    
    @RequestMapping("modules/{module}/{url}.html")
    public String module(@PathVariable("module") String module, @PathVariable("url") String url){
        logger.info("请求URL地址为:{}","modules/" + module + "/" + url);
        return "modules/" + module + "/" + url;
    }
    
}
