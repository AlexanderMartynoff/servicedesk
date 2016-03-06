package com.itsmtools.config.springframework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {

        builder.userDetailsService(userDetailsService);

        // if db is empty - we have this user :)
        builder.inMemoryAuthentication()
            .withUser("admin")
            .password("admin")
            .roles("GLOBAL");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login", "/public/**")
            .permitAll()
            .antMatchers("/**")
            .authenticated()
            .and()
            .csrf()
            .disable()
            //.exceptionHandling()
            // for AJAX response 401
            // .authenticationEntryPoint(authenticationEntryPoint)
            //.and()
            .formLogin()
            .loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .loginProcessingUrl("/auth")
            .successHandler(authenticationSuccessHandler)
            .failureHandler(authenticationFailureHandler)
            .and()
            .logout()
            .logoutSuccessUrl("/login")
            .logoutUrl("/logout");
    }
}