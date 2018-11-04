package com.zy.cn.controller;

import com.zy.cn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    private final String url = "http://springcloud-provider";

    //使用restTemplate对rest接口进行调用 封装的对象
    //RestTemplate对象提供了多种便捷访问远程http服务的方法 是一种简单便捷的restful服务模板类,是spring提供的用于访问rest服务的客户端模板类
    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private LoadBalancerClient loadBalancerClient;


    //调用服务端的查询所有的服务
    @RequestMapping(value = "/cs")
    public Object cs(){
        System.out.println("==========进入访问方法============");
        this.loadBalancerClient.choose("client");//随机访问策略
        List forObject = restTemplate.getForObject(url+"/queryAll", List.class);
        return  forObject;
    }





    //调用服务端的添加用户的服务
    @RequestMapping(value = "/insert",produces = "application/json; charset=utf-8")
    public Object insert(User user){
        System.out.println("==========进入访问方法============");
        restTemplate.postForObject(url+"/insert" ,user, String.class);
        return "OK";
    }

    //调用服务端的查询所有的服务
    @RequestMapping(value = "/queryAll")
    public Object queryAll(){
        System.out.println("==========进入访问方法============");
        List forObject = restTemplate.getForObject(url+"/queryAll", List.class);
        return  forObject;
    }

    //调用服务端的查询单个用户的服务
    @RequestMapping(value = "/find/{id}",produces = "application/json; charset=utf-8")
    public Object find(@PathVariable("id") Integer id){
        System.out.println("==========进入访问方法============");
        String forObject = restTemplate.getForObject( url+"/find/" + id, String.class);
        return forObject;
    }



}
