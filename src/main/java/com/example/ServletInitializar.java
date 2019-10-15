package com.example;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by lincg on 2017/5/2.
 */
//tomcat启动服务需要这个类
// SpringBootServletInitializer这个类是springboot提供的web程序初始化的入口，
// 当我们使用外部容器（tomcat）运行项目时会自动加载并且装配。
@SpringBootApplication
public class ServletInitializar extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServletInitializar.class);
    }

}
