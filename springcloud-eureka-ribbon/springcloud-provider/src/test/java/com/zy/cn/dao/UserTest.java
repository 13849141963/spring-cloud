/*
package com.zy.cn.dao;
import com.zy.cn.ApplicationContext;
import com.zy.cn.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

*/
/****
 * 测试用户的数据表格
 *//*

public class UserTest extends ApplicationContext {


    @Autowired
    private UserDAO userDAO;


    //查询所有
    @Test
    public void testQueryAll(){
        List<User> list = userDAO.queryAll();
        for (User user : list) {
            System.out.println(user.getName());
        }
    }

    //插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("路虎");
        user.setAge(28);
        userDAO.insert(user);
    }

    //查询单个数据
    //
    @Test
    public void testFindId(){
        User user = userDAO.find(52);
        System.out.println(user.getName());
    }


}
*/
