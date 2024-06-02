package com.example.demo_security;

import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * UserDetailsService authentication - you can define where to fetch data from. We can fetch from literally anywhere, below are some of the examples
     * 1. databases (sql or no-sql)
     * 2. caches
     * 3. file
     * 4. blob storage (s3, gcs)
     * 5. some other application / service
     *
     * @param auth
     * @throws Exception
     */

    @Autowired
    DemoUserDetailsService demoUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(demoUserDetailsService);
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
