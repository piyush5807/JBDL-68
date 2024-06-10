package com.example.minorproject1.configs;

import com.example.minorproject1.models.Authority;
import com.example.minorproject1.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    @Bean
    public AuthenticationManager authenticationManager(UserService userService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        (authz) -> authz
                                .requestMatchers("/admin/**").hasAuthority(Authority.ADMIN.name())
                                .requestMatchers("/**").permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
     * security config --> password config
     * security config --> user service
     *
     * user service --> password config
     */

//    @Bean
//    public InMemoryUserDetailsManager configureAuthentication(){
//
//        UserDetails u1 = User.builder()
//                .username("Dhruv")
//                .password("dhru@123")
//                .build();
//
//        UserDetails u2 = User.builder()
//                .username("Gaurav")
//                .password("gaurav@123")
//                .build();
//
//        return new InMemoryUserDetailsManager(u1, u2);
//    }
}
