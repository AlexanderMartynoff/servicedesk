package com.itsmtools.agent.config.springframework;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itsmtools.common.service.hibernate.HibernateSessionFactoryBuilder;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@EnableAspectJAutoProxy
@Configuration
@ComponentScan({
    "com.itsmtools.agent",
    "com.itsmtools.common"
})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    private String[] resourcesDirs = new String[] {
        "/WEB-INF/public/",
        "classpath:/META-INF/resources/public/"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations(resourcesDirs);
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
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