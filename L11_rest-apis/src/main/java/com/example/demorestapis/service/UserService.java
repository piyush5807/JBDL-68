package com.example.demorestapis.service;

import com.example.demorestapis.requestDtos.UserRequest;
import com.example.demorestapis.models.User;
import com.example.demorestapis.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }

    public User create(UserRequest userRequest){

        User user = to(userRequest);
        user = userRepository.create(user);
        return user;

        // Convert the dto into model
        // then pass the model to the repository layer
    }

    public void create2(User user){

        userRepository.create(user);

        // Convert the dto into model
        // then pass the model to the repository layer
    }

    public User get(Integer id){
        return userRepository.get(id);
    }

    public User to(UserRequest userRequest){
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setGender(userRequest.getGender());

        return user;
    }
}
