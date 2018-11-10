package com.zy.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String getString(){
        System.out.println("==========进入访问方法============");
        return "测试成功~~~~";
    }


}
