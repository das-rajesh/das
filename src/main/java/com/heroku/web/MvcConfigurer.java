/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author RAJESH
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.heroku.web")
@PropertySource(value = "classpath:application.properties")
public class MvcConfigurer {

    @Value(value = "${jdbc.driverClassName}")
    private String driverClassName;

    @Value(value = "${jdbc.url}")
    private String jdbcURL;

    @Value(value = "${jdbc.username}")
    private String jdbcUserName;

    @Value(value = "${jdbc.password}")
    private String jdbcPassword;

    @Value(value = "${view.prefix}")
    private String viewPrefix;

    @Value(value = "${view.suffix}")
    private String viewSuffix;

    @Bean
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource(jdbcURL, jdbcUserName, jdbcPassword);
         dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver(viewPrefix, viewSuffix);

        return vr;
    }
}
