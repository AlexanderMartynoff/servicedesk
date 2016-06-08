package com.itsmtools.common.service.hibernate;


import org.hibernate.SessionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.io.IOException;
import java.util.Properties;


public class HibernateSessionFactoryBuilder {
    private Properties hibernateProperties;
    private DriverManagerDataSource dataSource;

    public HibernateSessionFactoryBuilder() {
        hibernateProperties = new Properties();
        Properties dbProperties = new Properties();

        try{
            hibernateProperties.load(getClass()
                .getClassLoader()
                .getResourceAsStream("hibernate.properties"));
            dbProperties.load(getClass()
                .getClassLoader()
                .getResourceAsStream("db.properties"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbProperties.getProperty("driver_class_name"));
        dataSource.setUrl(dbProperties.getProperty("data_source_url"));
        dataSource.setUsername(dbProperties.getProperty("data_source_username"));
        dataSource.setPassword(dbProperties.getProperty("data_source_password"));
    }

    public SessionFactory getSessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.addProperties(hibernateProperties);
        builder.addPackages("com.itsmtools.common.dictionary.model");
        builder.scanPackages("com.itsmtools.common.dictionary.model");
        return builder.buildSessionFactory();
    }
}
