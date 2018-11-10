package com.zy.cn;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@MapperScan("com.zy.cn.dao")
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudProviderApplication  {
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProviderApplication.class, args);
	}
}
