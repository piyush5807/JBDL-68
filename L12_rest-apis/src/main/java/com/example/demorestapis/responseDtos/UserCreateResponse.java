package com.example.demorestapis.responseDtos;

import com.example.demorestapis.models.User;

import java.util.Date;

public class UserCreateResponse {

    private Integer id;
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static UserCreateResponse from(User user){
        UserCreateResponse userCreateResponse = new UserCreateResponse();
        userCreateResponse.setId(user.getId());
        userCreateResponse.setCreatedAt(user.getCreatedAt());
        return userCreateResponse;
    }
}
