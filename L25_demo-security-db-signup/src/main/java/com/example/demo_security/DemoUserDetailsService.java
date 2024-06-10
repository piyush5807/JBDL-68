package com.example.demo_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository.findByUsername(username).get(0);
    }

    public void create(DemoUser demoUser){
        String encodedPwd = passwordEncoder.encode(demoUser.getPassword());
        demoUser.setPassword(encodedPwd);
        this.userRepository.save(demoUser);
    }
}

/**
 * democontroller --> demoUserDetailsService
 * demoUserDetailsService --> passwordEncoderConfig --> passwordEncoder
 * demoConfig --> demoUserDetailsService  (how to authenticate : {for fetching user details })
 * demoConfig --> passwordConfig
 */

/**
 * SOLID principles :
 * S --> Single responsibility principle :
 */