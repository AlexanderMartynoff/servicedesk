package com.itsmtools.config.springframework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itsmtools.service.hibernate.HibernateSessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan("com.itsmtools")
public class BaseConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("/WEB-INF/public/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean(name = "defaultHibernateSession")
    public Session hibernateSession() {
        return new HibernateSessionFactoryBuilder().getSessionFactory().openSession();
    }

    @Bean(name = "defaultHibernateSessionFactory")
    public SessionFactory hibernateSessionFactory() {
        return new HibernateSessionFactoryBuilder().getSessionFactory();
    }

    @Bean(name = "defaultGson")
    public Gson gson() {
        return new Gson();
    }

    @Bean(name = "defaultJacksonObjectMapper")
    public ObjectMapper jacksonObjectMapper(){
        return new ObjectMapper();
    }
}