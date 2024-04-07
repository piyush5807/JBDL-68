package com.example.demorestapis.controllers;

import com.example.demorestapis.models.User;
import com.example.demorestapis.requestDtos.UserCreateRequest;
import com.example.demorestapis.responseDtos.UserCreateResponse;
import com.example.demorestapis.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {

    private UserService userService;

    public UserController2() {
        this.userService = new UserService();
    }

//    @PostMapping("/user") // this is the newer way of defining APIs
////    @RequestMapping(value = "/user/create", method = RequestMethod.POST) // this is an older way of defining APIs
//    public UserCreateResponse createUser1(@RequestBody UserCreateRequest userCreateRequest){
//
//        // taking some action on the data given -->
//
//        // JSON --> Java object (Spring web classes)
//
//        User user = userService.create(userCreateRequest);
//        return UserCreateResponse.from(user);
//    }

    /**
     * A web server cannot have duplicate APIs be it one controller or spread across multiple controllers
     * Duplicate API :
     *      1. Path:
     *      2. Method :
     */

    /**
     * POST - /user (UserController)
     * POST - /user (UserController2)
     * GET - /user (UserController)
     * PATCH -
     * PUT -
     * DELETE -
     *
     */
}
