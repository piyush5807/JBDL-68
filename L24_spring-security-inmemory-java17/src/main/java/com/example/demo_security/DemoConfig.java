package com.example.demo_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoConfig {


    @Bean
    public InMemoryUserDetailsManager configureAuthentication(){

        UserDetails u1 = User.builder()
                .username("Dhruv")
                .password("dhru@123")
                .build();

        UserDetails u2 = User.builder()
                .username("Gaurav")
                .password("gaurav@123")
                .build();

        return new InMemoryUserDetailsManager(u1, u2);
    }



}
