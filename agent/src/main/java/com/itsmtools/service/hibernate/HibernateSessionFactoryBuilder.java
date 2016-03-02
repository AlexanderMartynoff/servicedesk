package com.itsmtools.service.hibernate;


import org.hibernate.SessionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.util.Properties;


public class HibernateSessionFactoryBuilder {
    private Properties properties;
    private DriverManagerDataSource dataSource;

    public HibernateSessionFactoryBuilder() {
        properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("use_sql_comments", "true");
        properties.put("hibernate.connection.CharSet", "utf8");
        properties.put("hibernate.connection.characterEncoding", "utf8");
        properties.put("hibernate.connection.useUnicode", "true");

        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/itsmtools?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("8888");
    }

    public SessionFactory getSessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.addProperties(properties);
        builder.addPackages("com.itsmtools.dictionary.model");
        builder.scanPackages("com.itsmtools.dictionary.model");
        return builder.buildSessionFactory();
    }
}
