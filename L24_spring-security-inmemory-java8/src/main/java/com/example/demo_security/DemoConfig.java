package com.example.demo_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("Gaurav")
                .password("$2a$10$dhNe/PgFBYumbt4GJ9uBHuXwBxL8PHkTTxheNyaT0ffPAQ0HWtCW2")
                .authorities("usr")
                .and()
                .withUser("Sandeep")
                .password("$2a$10$EWleKVk6I.D7sSW5TtDZF.1Zho8v5EEkpsf7uanfqJUfMH86N.eza")
                .authorities("adm");
//                .and()
//                .withUser("Rohit")
//                .password("userNotFoundPassword")
//                .authorities("admin", "user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/**").hasAuthority("usr")
                .antMatchers("/admin/**").hasAuthority("adm")
                .antMatchers("/**").permitAll()   // skip authentication
                .and()
                .formLogin();

    }

    @Bean
    PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();

//        return NoOpPasswordEncoder.getInstance();
    }


}
