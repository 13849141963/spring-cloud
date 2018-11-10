package com.zy.cn.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
@Configuration
@MapperScan("com.zy.cn.*")
//加载数据源以及mybatis的相关配置信息
@EnableConfigurationProperties({DataSourceProperties.class,MybatisSourceProperties.class})
//通过使用@ConfigurationProperties注解实现了配置信息的注入；
// 然后又通过使用@EnableConfigurationProperties注解才使得配置bean被创建出来
@EnableTransactionManagement//事务管理器
public class MybatisDataSource {

    @Autowired
    private  DataSourceProperties dataSourceProperties;

    @Autowired
    private MybatisSourceProperties mybatisSourceProperties;

    private DruidDataSource datasource = null;

    //创建数据源组件
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        datasource = new DruidDataSource();
        //注入连接数据库的·url地址
        datasource.setUrl(dataSourceProperties.getUrl());
        //注入类型
        datasource.setDbType(dataSourceProperties.getType());
        datasource.setDriverClassName(dataSourceProperties.getDriverClassName());
        //注入用户名密码
        datasource.setUsername(dataSourceProperties.getUsername());
        datasource.setPassword(dataSourceProperties.getPassword());
        return datasource;
    }

    @PreDestroy
    public void close() {
        if(datasource != null){
            //关闭数据源
            datasource.close();
        }
    }

    //创建sqlSessionFactory连接对象
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //注入数据源组件
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //mybatis的mapper配置文件位置
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mybatisSourceProperties.getMapperLocations()));
        //指定实体别名的位置
        sqlSessionFactoryBean.setTypeAliasesPackage(mybatisSourceProperties.getTypeAliasesPackage());
        return sqlSessionFactoryBean.getObject();
    }

    //创建事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() {
        //注入数据源对象
        return new DataSourceTransactionManager(dataSource());
    }
}
