package com.example.demorestapis.repository;

import com.example.demorestapis.exceptions.NotFoundException;
import com.example.demorestapis.models.User;

import java.io.IOException;
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

    /**
     *
     * insert into __ ()
     * update if exists __ set '' __ where id = __
     * @param userId
     * @return
     */

    public User get(Integer userId){
        return this.userMap.get(userId); // (user)
    }

    public User update(Integer userId, User user){

        if(!this.userMap.containsKey(userId)){
            return null;
        }

        this.userMap.put(userId, user);
        return user;
    }

    /**
     * 1. Deleting from the datastore (HashMap)
     * 2. Deleting the temp file for that particular user
     * @param id
     */

    public void delete(Integer id){

//        try {
            if (!userMap.containsKey(id)) {
                throw new NotFoundException("user not found"); // 400
            }

            this.userMap.remove(id);

//        }catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }
    }
}
