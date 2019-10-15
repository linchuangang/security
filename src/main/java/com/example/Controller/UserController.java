package com.example.Controller;

import com.alibaba.fastjson.JSON;
import com.example.Dao.user.UserDao;
import com.example.Entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    static Logger logger = Logger.getLogger(HelloController.class);

    public static void main(String[] args) {
        logger.info("------");
    }
    @Autowired
    UserDao userDao;

//    @PreAuthorize("hasAnyRole('USER')") // 只能user角色才能访问该方法
    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
    public String test() {
        return "test";
    }


//    @PreAuthorize("hasAnyRole('ADMIN')") // 只能user角色才能访问该方法
    @RequestMapping(value = "/testRole", method = {RequestMethod.POST, RequestMethod.GET})
    public String testRole() {
        return "testRole";
    }

    @RequestMapping(value = "/testOther", method = {RequestMethod.POST, RequestMethod.GET})
    public String testOther() {
        return "testOther";
    }

    @RequestMapping(value = "/testNo", method = {RequestMethod.POST, RequestMethod.GET})
    public String testNo() {
        return "testNo";
    }


    @RequestMapping(value = "getList", method = {RequestMethod.POST, RequestMethod.GET})
    public String getList() {
        List<User> userList = userDao.findAll();
        return JSON.toJSONString(userList);
    }

    //save 方法可以添加也可以更新，根据是否有id判断
    @RequestMapping(value = "add", method = {RequestMethod.POST, RequestMethod.GET})
    public User add() {
        User user = new User();
        user.setName("cesi");
        user.setMobile("11111111111");
        user.setPassword("111");
        user.setCreateTime(new Date());
        userDao.save(user);
        return user;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST, RequestMethod.GET})
    public void delete() {
        userDao.delete(264L);
    }
}
