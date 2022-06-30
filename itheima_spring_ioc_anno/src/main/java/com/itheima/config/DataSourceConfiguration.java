package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("jdbc.properties")
public class DataSourceConfiguration {
    @Value("${jdbc.driver")
    private String driver;
    @Value("${jdbc.url")
    private String url;
    @Value("${jdbc.username")
    private String username;
    @Value("${jdbc.password")
    private String password;


    @Bean(name="dataSource")//接受返回值，name起名字
    public DataSource getDataSource()throws Exception{
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
