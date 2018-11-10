package com.zy.cn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
//@ConfigurationProperties 标注的“已经存在”的 bean 都会从系统环境中加载配置信息
@ConfigurationProperties(prefix = MybatisSourceProperties.PREFIX, ignoreUnknownFields = false)
//通过使用@ConfigurationProperties注解实现了配置信息的注入；
// 然后又通过使用@EnableConfigurationProperties注解才使得配置bean被创建出来
public class MybatisSourceProperties {

    //指定远程配置文件前缀
    public final static String PREFIX = "mybatis";
    //mapper配置文件位置
    private String mapperLocations;
    //实体的别名
    private String typeAliasesPackage;


    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }
}
