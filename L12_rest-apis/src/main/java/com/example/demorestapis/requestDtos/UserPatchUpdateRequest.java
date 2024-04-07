package com.example.demorestapis.requestDtos;

import com.example.demorestapis.models.User;

import java.util.Date;

public class UserPatchUpdateRequest {

    private Integer age;

    private String email;

    private String password;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User to(){
        User user = new User();
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setAge(this.age);
        user.setUpdatedAt(new Date());

        return user;
    }
}
