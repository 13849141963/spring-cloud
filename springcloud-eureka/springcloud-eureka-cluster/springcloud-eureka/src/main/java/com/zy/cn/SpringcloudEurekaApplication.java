package com.zy.cn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer//该注解表示使用Eureka服务注册中心
@SpringBootApplication
public class SpringcloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaApplication.class, args);
    }
}
