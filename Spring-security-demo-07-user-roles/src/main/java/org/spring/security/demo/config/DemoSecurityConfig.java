package org.spring.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // add our users for in memory authentication
        UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("Jonas").password("123").roles("DARBUOTOJAS"))
                .withUser(users.username("Maryte").password("123").roles("VADYBININKAS", "DARBUOTOJAS"))
                .withUser(users.username("Onute").password("123").roles("ADMINISTRATORE", "DARBUOTOJAS"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests()
//                .anyRequest().authenticated()
             .antMatchers("/").hasRole("DARBUOTOJAS")
             .antMatchers("/leaders/**").hasAnyRole("VADYBININKAS")
             .antMatchers("/systems/**").hasRole("ADMINISTRATORE")
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
