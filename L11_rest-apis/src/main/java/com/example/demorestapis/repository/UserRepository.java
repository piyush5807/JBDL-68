package com.example.demorestapis.repository;

import com.example.demorestapis.models.User;

import java.util.HashMap;
import java.util.Random;

public class UserRepository { // here we should only have models

    HashMap<Integer, User> userMap = new HashMap<>(); // this is acting like a data store

    public User create(User user){
        Integer userId = new Random().nextInt(100);
        user.setId(userId);
        this.userMap.put(userId, user);
        return user;
    }

    public User get(Integer userId){
        return this.userMap.get(userId); // (user)
    }
}
