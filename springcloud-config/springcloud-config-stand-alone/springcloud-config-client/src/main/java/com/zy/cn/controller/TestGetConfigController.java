package com.zy.cn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestGetConfigController {

    @Value("${config-file}")
    String configFile;

    @RequestMapping(value = "/getConfigFile")
    public String getConfigFile(){
        return configFile;
    }
}
