package com.example.demorestapis.responseDtos;

import com.example.demorestapis.models.User;
import com.example.demorestapis.requestDtos.UserUpdateRequest;

import java.util.Date;

public class UserUpdateResponse {

    private Integer id;
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static UserUpdateResponse from(User user){
        UserUpdateResponse userUpdateResponse = new UserUpdateResponse();
        if(user == null){
            return null;
        }
        userUpdateResponse.setId(user.getId());
        userUpdateResponse.setUpdatedAt(user.getUpdatedAt());
        return userUpdateResponse;
    }
}
