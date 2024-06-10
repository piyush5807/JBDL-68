package com.example.minorproject1.services;

import com.example.minorproject1.configs.PasswordEncoderConfig;
import com.example.minorproject1.models.Authority;
import com.example.minorproject1.models.User;
import com.example.minorproject1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username).orElse(null);
    }

    public User create(User user, Authority authority){
        String encodedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPwd);
        user.setAuthorities(authority);
        return this.userRepository.save(user);
    }
}
