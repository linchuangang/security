package com.example.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/hello")
public class HelloController {

    private static Logger logger = Logger.getLogger(HelloController.class);
    @Value("${age}")
    private String age;
    @Value("${size}")
    private int size;

    public static void main(String[] args) {
        logger.info("info");
        logger.error("error");
        logger.warn("warn");
        logger.debug("debug");
    }

    //http://localhost:8080/hello/12
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@PathVariable String name) {
        logger.info("来了来了");
        return "hello==" + name + "==" + age + "==" + size;
    }


    //http://localhost:8080/wooo?name=lalala
    @RequestMapping(value = {"world", "wooo"})
    @ResponseBody
    public String world(@RequestParam(required = false, defaultValue = "什么鬼") String name) {
        return name;
    }

    /**
     * 测试hello
     *
     * @return http://localhost:8080/hi
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }

    /**
     * 测试hello
     *
     * @return http://localhost:8080/java
     */
    @RequestMapping(value = "/java", method = RequestMethod.GET)
    public String java(Model model) {
        model.addAttribute("name", "Dear");
        return "java";
    }


    //默认首页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("name", "lin");
        return "index";
    }

    public String cookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "lin");
        response.addCookie(cookie);
        Cookie[] c = request.getCookies();
        return "";

    }



}
