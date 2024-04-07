package com.example.demorestapis.requestDtos;

import com.example.demorestapis.models.Gender;
import com.example.demorestapis.models.User;

import java.util.Date;

public class UserUpdateRequest {

    private String name;

    private String email;

    private String password;

    private Integer age;

    private Gender gender;

    private Date createdAt;

    private Date updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User to(Integer userId){
        User user = new User();
        user.setAge(this.age);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setGender(this.gender);
        user.setCreatedAt(this.createdAt);
        user.setUpdatedAt(new Date());
        user.setId(userId);


        return user;
    }
}
