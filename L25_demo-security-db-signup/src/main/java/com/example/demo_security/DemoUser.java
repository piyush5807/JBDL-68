package com.example.demo_security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoUser implements UserDetails {

    private static final String DELIMITER = "::";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    private String password; // encrypted form

    private String authorities; // usr::adm

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){

        String[] authorities = this.authorities.split(DELIMITER);

        return Arrays.stream(authorities)
                .map(x -> new SimpleGrantedAuthority(x))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
