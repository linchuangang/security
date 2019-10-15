package com.example;

import com.alibaba.fastjson.JSON;
import com.example.Dao.user.UserDao;
import com.example.Entity.User;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */
public class userTest extends DemoApplicationTests {

    @Resource
    UserDao userDao;

    @Test
    public void testFind() {
        List<User> list = userDao.findBy(266L);
        System.out.println(JSON.toJSONString(list));

        List<User> list2 = userDao.findBy2(266L);
        System.out.println(JSON.toJSONString(list2));
    }

    @Test
    public void testDelete() {
        userDao.delete("18368093686", "1");


        Integer size = userDao.update(266L, "haha");
        System.out.println(size);
    }

    @Test
    public void testPage() {
        User user = new User();
        user.setSize(2);
        user.setPage(0);
        PageRequest page = new PageRequest(user.getPage(), user.getSize());
        Page<User> userPage = userDao.findAll(page);
        System.out.println(JSON.toJSONString(userPage.getContent()));
    }

}
