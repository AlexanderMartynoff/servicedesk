package com.itsmtools.agent.config.springframework;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class ApplicationInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext applicationContext =
            new AnnotationConfigWebApplicationContext();

        applicationContext.setServletContext(servletContext);
        applicationContext.register(BaseConfig.class);

        ServletRegistration.Dynamic servlet =
            servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy())
            .addMappingForUrlPatterns(null, true, "/*");
    }
}