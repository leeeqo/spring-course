package com.zt.spring.security.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        // temporary solution
        /*User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("zaur").password("zaur").roles("EMPLOYEE"))
                .withUser(userBuilder.username("elena").password("elena").roles("HR"))
                .withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER"));*/

        // Using passwords from database
        auth.jdbcAuthentication().dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr_info/**").hasRole("HR")
                .antMatchers("/managers_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll();

    }
}
