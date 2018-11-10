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
    private UserService userServices;

    @Test
    public void contextLoads() {

        List<User> users = userDAO.queryAll();

        for (User user : users) {

            System.out.println(user);
        }

        List<User> users1 = userServices.queryAll();
        for (User user : users1) {

            System.out.println(user);
        }
    }

}
