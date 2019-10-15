package com.example;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication//声明这个类是boot的入口类，一个springboot类里面只能有一个这个注解
@RestController
@ServletComponentScan//Druid配置-->spring能够扫描到我们自己编写的servlet和filter
@EnableScheduling//定时任务配置
public class DemoApplication {
    /*
     要使用main方法启动需要去掉这个包
     <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-tomcat</artifactId>
     <scope>provided</scope>
     </dependency>
     */
    public static void main(String[] args) {
//        SpringApplication springApplication=new SpringApplication(DemoApplication.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.run(args);

        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping(value = "/go", method = RequestMethod.GET)
    public String go() {
        return "gogogo";
    }
}
