package com.cn.tianxia.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import net.sf.oval.Validator;

/**
 * 
 * @ClassName Bootstrap
 * @Description 启动类
 * @author Hardy
 * @Date 2019年4月16日 下午5:22:04
 * @version 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Bootstrap extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Bootstrap.class);
    }
    
    /**
     * 
     * @Description 数据校验
     * @return
     */
    @Bean
    public Validator validator(){
        Validator validator = new Validator();
        return validator;
    }
    
}
