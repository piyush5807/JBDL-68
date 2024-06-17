package com.example.minorproject1.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {


    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
