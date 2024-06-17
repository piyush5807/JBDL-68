package com.example.minorproject1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User implements UserDetails, Serializable {

    /**
     * select * from student where username = ? {studentId} {Approach 2} logN
     * select * from user where username = ? {studentId} {Approach 1} logN
     */

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Authority authorities;

    @OneToOne(mappedBy = "user") // back referencing | bi-directional relationship
    @JsonIgnoreProperties("user")
    private Student student;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Admin admin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.authorities.name()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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

/**
 * students - thousands
 * Admins - tens --> hundreds
 *
 * 1st approach
 *
 * user table
 *  username            pwd         authorities         student_id          admin_id
 *  rohit@gmail.com     -           STUDENT              1                  NULL
 *  dhruv@gmail.com     -           STUDENT              2                  NULL
 *  ..
 *  100 students
 *  Khushi@gmail.com                         ADMIN                NULL                 1
 *
 *
 * 2nd approach
 *
 * student table
 *
 * id     name        username
 *
 * 1      Rohit      rohit@gmail.com
 * 2      Dhruv      dhruv@gmail.com
 *
 *
 * Admin table
 *
 * id     name       username
 * 1      Khushi     khushi@gmail.com
 *
 */



/**
 * Association
 * User <-> Student (1:1)
 * User <-> Admin  (1:1)
 *
 * Where can we store the Foreign key ?
 * User table - {studentId and AdminId will be two foreign keys}
 * or
 * Student and Admin table (user id will be the foreign key)
 */













