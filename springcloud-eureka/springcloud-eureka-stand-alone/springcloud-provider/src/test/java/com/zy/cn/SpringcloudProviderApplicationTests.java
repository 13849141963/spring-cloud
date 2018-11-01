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
public class SpringcloudProviderApplicationTests {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    UserService userService;

    /*@Test
    public void contextLoads() {

        User user = new User();
        user.setName("捷豹");
        user.setAge(28);
        userDAO.insert(user);

        List<User> list = userDAO.queryAll();
        for (User users : list) {
            System.out.println(users.getName());
        }


        User user1 = userDAO.find(10);
        System.out.println(user1.getName());
    }*/


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
