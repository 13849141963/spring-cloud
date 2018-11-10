package com.zy.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.zy.cn.dao")
@EnableEurekaClient
//将spring boot自带的DataSourceAutoConfiguration禁掉，防止自动配置数据源
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringcloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderApplication.class, args);
    }
}
