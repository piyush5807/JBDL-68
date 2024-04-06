package com.example.demorestapis.controllers;

import com.example.demorestapis.requestDtos.UserRequest;
import com.example.demorestapis.responseDtos.UserCreateResponse;
import com.example.demorestapis.responseDtos.UserResponse;
import com.example.demorestapis.models.User;
import com.example.demorestapis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // This annotation makes a classes visible as a controller to the dispatcher servlet
public class UserController {

    /**
     * Classes doing some action
     * Controller - defining all the endpoints / API / contract that the client will adhere to
     * Service - Does the actual business logic
     * Repository - Does the data management part by interacting with the underlying datastore (db, cache, internal memory)
     *
     * Classes which are representing some sort of data and used by the above 3 classes
     * Models - Repository used for data management with the underlying datastore
     * Request DTOs
     * Response DTOs
     *
     * DAO - Data access object
     *
     * Client   -->     Controller   -->     Service      -->     Repository/DAO    -->       datastore  (data addition / modification / deletion)
     *       (RequestDTO)           (model)             (model)                   (model)
     *
     * Client   <--     Controller   <--     Service      <--     Repository    <--    datastore (data retrieval)
     *      (ResponseDTO)           (model)             (model)                   (model)
     *
     *
     *
     *
     * Client   -->     Controller   -->     Service      -->     Repository/DAO    -->       datastore  (data addition / modification / deletion)
     *       (RequestDTO)      (RequestDTO)             (model)                   (model)
     *
     * Client   <--     Controller   <--     Service      <--     Repository/DAO    <--    datastore (data retrieval)
     *      (ResponseDTO)      (ResponseDTO)             (model)                  (model)
     */

    // 20 attributes

    // 2 attributes

    // 3 attributes - sensitive

    // Disadvantages
    // 1. extra data => extra latency
    // 2. to gather that extra data, you might need to query different tables

    // Advantages:
    // 1. Clients can increase in future with different requirements

    /**
     * create - FE will send some data for the user creation => BE creates the user
     * get - FE wants to retrieve the user
     */

    /**
     * Client will have to map the data accordingly in their framework
     * integer java --> number in javascript
     * client retrieves the number and tries to some string operation, that can fail
     *
     * Java --> JSON (javascript object notation)
     * Scaling the response dto attributes in future can become a challenge
     *
     * Analyze all the response payloads that your controller is sending
     *
     * 1. Integration at Client side
     * 2. Scaling and extensibility
     * 3. Visibility of all the response dtos / payloads
     */

//    public Integer createUser(UserRequest userRequest){
//
//        // JSON --> Java object (Spring web classes)
//
//        UserService userService = new UserService();
//        return userService.create(userRequest).getId();
//    }

    /**
     * Rest and Soap architecture
     *   Rest APIs are stateless whereas SOAP can be stateless or stateful
     *   Soap API returns XML data but Rest apis can return json or xml or any other type of data
     *
     * Banking - threat detection, malicious activities, cloud security
     *
     * HTTP Request METHODS:
     * GET : Retrieving some info / data from the server
     * POST: Add some info / data on the server
     * PUT: Update some info / data on the server
     * PATCH: Update some info / data on the server
     * DELETE: Delete some info / data on the server
     *
     *
     * amazon.com/shopping
     * amazon.com/payment
     * amazon.com/profile
     * @param userRequest
     * @return
     */

    /**
     * Stateful --> data that is sent in the request + other parameters
     *        other parameters : user related information
     *                           some other information already stored on the server
     * @param userRequest
     * @return
     */

    private UserService userService;

    public UserController(){
        System.out.println("UserController: inside constructor");
        this.userService = new UserService();
    }

    @PostMapping("/user/create") // this is the newer way of defining APIs
//    @RequestMapping(value = "/user/create", method = RequestMethod.POST) // this is an older way of defining APIs
    public UserCreateResponse createUser1(@RequestBody UserRequest userRequest){

        // taking some action on the data given -->

        // JSON --> Java object (Spring web classes)

        User user = userService.create(userRequest);
        return UserCreateResponse.from(user);
    }

//    public void createUser2(UserRequest userRequest){
//
//        UserService userService = new UserService();
//        userService.create2(userRequest.to());
//    }

    @GetMapping("/user/fetch")
    public UserResponse getUser(@RequestParam("id") Integer userId){

        // Java --> JSON (spring web classes)

        System.out.println("Inside get: " + Thread.currentThread().getName());

        User user = userService.get(userId);
        return UserResponse.from(user);
    }

    /**
     * Controller is having only 1 object :
     *
     */
}
