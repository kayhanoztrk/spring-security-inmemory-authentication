package com.inmemory.authentication.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/product/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/product/delete/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/product/update/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/product/list").hasAnyRole("ADMIN", "USER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }
}
