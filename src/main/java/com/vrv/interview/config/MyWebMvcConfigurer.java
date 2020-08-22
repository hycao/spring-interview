package com.vrv.interview.config;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc 的配置
 *
 * @author hycao
 */
@Component
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    public MyWebMvcConfigurer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // MVC 相关配置请添加在此处

}
