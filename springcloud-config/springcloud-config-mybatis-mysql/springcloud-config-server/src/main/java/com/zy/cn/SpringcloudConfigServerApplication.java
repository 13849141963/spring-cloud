package com.zy.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//分布式配置中心注解
@EnableConfigServer
//发现注册中心
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigServerApplication.class, args);
    }
}
