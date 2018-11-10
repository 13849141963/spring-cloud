package com.zy.cn.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 该类配置数据源相关属性
 * 从springcloud config远程github获取配置文件信息
 */
//https://www.breakyizhan.com/springboot/3287.html Springboot中文文档24.7
@ConfigurationProperties(prefix = DataSourceProperties.PREFIX, ignoreUnknownFields = false)
//当以@ConfigurationProperties这种方式注册bean时，该bean具有常规名称：<prefix>-<fqn>，睡醒
//其中<prefix>是在@ConfigurationProperties注释中指定的环境[系统环境]键前缀，并且<fqn>是bean的完全限定名称。
//如果注释没有提供任何前缀，则只使用bean的完全限定名称。


//通过使用@ConfigurationProperties注解实现了配置信息的注入；
// 然后又通过使用@EnableConfigurationProperties注解才使得配置bean被创建出来
public class DataSourceProperties {

    public DataSourceProperties() {
        super();
    }
    //定义前缀    //对应远程配置文件里的key
    public final static String PREFIX = "spring.datasource";

    private String type;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int maxActive = 1000;
    private int maxIdle = 100;
    private int minIdle = 8;
    private int initialSize = 10;

    private boolean testOnBorrow = true;

    private boolean testOnReturn = false;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }
}
