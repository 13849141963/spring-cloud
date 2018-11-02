package com.zy.cn.controller;
import com.zy.cn.entity.User;
import com.zy.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/***
 * 操作用户的接口
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/queryAll") 等于下面的注解
    //@RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public Object queryAll(){
        List<User> users = userService.queryAll();
        return users;
    }
    @PostMapping("/insert")
    //@RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insert(@RequestBody User user){
        userService.inseret(user);
        return "OK";
    }
    @GetMapping("/find/{id}") 等于下面的注解
    //@RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public Object find(@PathVariable("id") Integer id){
        User user = userService.find(id);
        return user;
    }


}
