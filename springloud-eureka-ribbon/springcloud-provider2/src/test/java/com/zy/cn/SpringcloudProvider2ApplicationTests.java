package com.zy.cn;

import com.zy.cn.dao.UserDAO;
import com.zy.cn.entity.User;
import com.zy.cn.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudProvider2ApplicationTests {


    @Autowired
    private UserDAO userDAO;

    @Autowired
    UserService userService;
    
    @Test
    public void contextLoads() {
    }


    @Test
    public void contextLoadsService() {
        List<User> users = userService.queryAll();
        for (User user : users) {
            System.out.println(user.getName());
        }
        System.out.println("==============");
        User user1 = userService.find(10);
        System.out.println(user1.getName());
    }


}
