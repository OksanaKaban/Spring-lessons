package org.spring.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    // add reference to our security datasource
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     // use jdbc authentication . finally !!
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests()
//                .anyRequest().authenticated()
             .antMatchers("/").hasRole("EMPLOYEE")
             .antMatchers("/leaders/**").hasAnyRole("MANAGER")
             .antMatchers("/systems/**").hasRole("ADMIN")
             .and()
             .formLogin()
                .loginPage("/showLoginPage")
                .loginProcessingUrl("/authenticateUser")
                .permitAll()
             .and()
             .logout().permitAll()
             .and()
             .exceptionHandling().accessDeniedPage("/accessDenied");

    }
}
