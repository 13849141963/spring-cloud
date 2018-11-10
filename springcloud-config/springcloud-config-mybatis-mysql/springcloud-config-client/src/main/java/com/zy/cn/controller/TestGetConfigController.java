package com.zy.cn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class TestGetConfigController {

    /*@Value("${configFile}")
    String configFile;

    //String

    @RequestMapping(value = "/configFile")
    public String getConfigFile(){
        return this.configFile;
    }*/
    @Value("${spring.datasource.url}")
    String url;


    @RequestMapping(value = "/url")
    public String getConfigFile(){
        return this.url;
    }


}
