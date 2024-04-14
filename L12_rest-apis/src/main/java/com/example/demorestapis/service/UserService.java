package com.example.demorestapis.service;

import com.example.demorestapis.requestDtos.UserCreateRequest;
import com.example.demorestapis.models.User;
import com.example.demorestapis.repository.UserRepository;
import com.example.demorestapis.requestDtos.UserPatchUpdateRequest;
import com.example.demorestapis.requestDtos.UserUpdateRequest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserService {

    private UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }

    public User create(UserCreateRequest userCreateRequest){

        User user = userCreateRequest.to(); // 10 user objects
        user = userRepository.create(user); // 1 userRepository
        return user;

        // Convert the dto into model
        // then pass the model to the repository layer
    }

    public User update(Integer id, UserUpdateRequest userUpdateRequest){

        User user = userUpdateRequest.to(id);

        // log:
        return this.userRepository.update(id, user);
    }

    public User patchUpdate(Integer id, UserPatchUpdateRequest userPatchUpdateRequest){

        User user = userPatchUpdateRequest.to();
        User existingUser = get(id);

        if(existingUser == null){
            // 400
            return null;
        }

        // merge these users

        User data = mergeData(existingUser, user); // this is the heart of the patch method

        return this.userRepository.update(id, data);

    }

    public void create2(User user){

        userRepository.create(user);

        // Convert the dto into model
        // then pass the model to the repository layer
    }

    private User mergeData(User existingUser, User updatedUser){

        // Map : {k1: v1, k2: v2}
        // JSON : {k1: v1, k2: v2}
        // Java objects: {k1: v1, k2: v2}

        // JS: lodash
        // Java: json-simple, objectmapper of spring web

        /**
         * Typescript
         * a = {k1: v1, k3: v3}
         * b = {k2: v2, k3: v4}
         *
         * a & b = {...a, ...b} => {k1: v1, k2: v2, k3: v3}
         * b & a = {...b, ...a}
         *
         */

        if(updatedUser.getAge() != null){
            existingUser.setAge(updatedUser.getAge());
        }

        if(updatedUser.getEmail() != null){
            existingUser.setEmail(updatedUser.getEmail());
        }

        if(updatedUser.getPassword() != null){
            existingUser.setPassword(updatedUser.getPassword());
        }

//        if(updatedUser.getUpdatedAt() != null){
        existingUser.setUpdatedAt(updatedUser.getUpdatedAt());
//        }

        return existingUser;
    }

    public User get(Integer id){
        return userRepository.get(id);
    }


    public void delete(Integer id) throws IOException  {
        FileInputStream fileInputStream = new FileInputStream("abc.txt");
        fileInputStream.read();
        this.userRepository.delete(id);

//        try{
//            File.delete();
//        }catch (IOException e){
//            e.printStackTrace();
//        }


    }

    public void delete2(Integer id) throws Exception{
            int a = 1 / 0;
            this.userRepository.delete(id);
    }

    /**
     * Error handling can be done in 2 ways
     * 1. try catch block :
     *          1.1 suppress:
     *          1.2 pass it on to the calling function
     * 2. throws exception keyword
     */

//    public User to(UserCreateRequest userCreateRequest){
//        User user = new User();
//        user.setAge(userCreateRequest.getAge());
//        user.setName(userCreateRequest.getName());
//        user.setEmail(userCreateRequest.getEmail());
//        user.setPassword(userCreateRequest.getPassword());
//        user.setGender(userCreateRequest.getGender());
//
//        return user;
//    }
}
