package com.example.demorestapis.responseDtos;

import com.example.demorestapis.models.Gender;
import com.example.demorestapis.models.User;

import java.util.UUID;

public class UserSubscriptionResponse {

    private int id;
    private String name;

    private String email;

    private Integer age;

    private Gender gender;

    private String subscriptionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public UserSubscriptionResponse from(User user){
        UserSubscriptionResponse userResponse = new UserSubscriptionResponse();
        userResponse.age = user.getAge();
        userResponse.name = user.getName();
        userResponse.gender = user.getGender();
        userResponse.id = user.getId();
        userResponse.email = user.getEmail();
        userResponse.subscriptionId = UUID.randomUUID().toString();

        return userResponse;

    }
}
