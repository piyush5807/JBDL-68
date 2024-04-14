package com.example.demorestapis.controllers;

import com.example.demorestapis.exceptions.NotFoundException;
import com.example.demorestapis.requestDtos.UserCreateRequest;
import com.example.demorestapis.requestDtos.UserPatchUpdateRequest;
import com.example.demorestapis.requestDtos.UserUpdateRequest;
import com.example.demorestapis.responseDtos.UserCreateResponse;
import com.example.demorestapis.responseDtos.UserResponse;
import com.example.demorestapis.models.User;
import com.example.demorestapis.responseDtos.UserUpdateResponse;
import com.example.demorestapis.service.UserService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@RestController // This annotation makes a classes visible as a controller to the dispatcher servlet
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);



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

    /**
     * CRUD :
     *      CREATE :
     *      READ
     *      UPDATE
     *      DELETE
     *
     */

    private UserService userService;

    public UserController(){
        System.out.println("UserController: inside constructor");
        this.userService = new UserService();
    }



    @PostMapping("/user") // this is the newer way of defining APIs
//    @RequestMapping(value = "/user/create", method = RequestMethod.POST) // this is an older way of defining APIs
    public UserCreateResponse createUser1(@RequestBody UserCreateRequest userCreateRequest){

        // taking some action on the data given -->

        // JSON --> Java object (Spring web classes)

        User user = userService.create(userCreateRequest);
        return UserCreateResponse.from(user);
    }

//    public void createUser2(UserRequest userRequest){
//
//        UserService userService = new UserService();
//        userService.create2(userRequest.to());
//    }

    @GetMapping("/user")
    public UserResponse getUser(@RequestParam("id") Integer userId){

        // Java --> JSON (spring web classes)

        System.out.println("Inside get: " + Thread.currentThread().getName());

        User user = userService.get(userId);
        return UserResponse.from(user);
    }

    /**
     * Already present User data - {id : 1, name: ABC, age: 20}
     *  1. The client sends the entire data that needs to be updated : {id: 1, name: ABC, age: 30, email: abc@gmail.com}
     *     BE will save the incoming data blindly in the datastore (in memory, db, cache, file server, cloud storage)
     *
     *  2. The client sends only the attributes that needs to be updated: {email: abc@gmail.com}
     *     BE will merge the incoming data and the existing data and then save the result of the merge
     *         Example 1:
         *         incoming : {email: abc@gmail.com}
         *         existing: {id : 1, name: ABC, age: 20}
         *         merge result : {id: 1, name: ABC, age: 30, email: abc@gmail.com}
     *         Example 2:
     *             incoming : {email: abc@yahoo.com}
     *             existing data: {id: 1, name: ABC, age: 30, email: abc@gmail.com}
     *             merge result: {id: 1, name: ABC, age: 30, email: abc@yahoo.com}
     *
     */

    /**
     * Inputs from the FE / Client
     * https://www.google.com/search?q=ipl&oq=ipl+&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTINCAEQLhiDARixAxiABDIMCAIQIxgnGIAEGIoFMg0IAxAAGIMBGLEDGIAEMhAIBBAAGIMBGLEDGIAEGIoFMg0IBRAAGIMBGLEDGIAEMg0IBhAAGIMBGLEDGIAEMg0IBxAAGIMBGLEDGIAEMhAICBAAGIMBGLEDGIAEGIoFMg0ICRAAGIMBGLEDGIAE0gEIMTM5MmowajeoAgCwAgA&sourceid=chrome&ie=UTF-8
     * https://www.google.com/search/ipl/ipl+/EgZjaHJvbWUyBggAEEUYOTINCAEQLhiDARixAxiABDIMCAIQIxgnGIAEGIoFMg0IAxAAGIMBGLEDGIAEMhAIBBAAGIMBGLEDGIAEGIoFMg0IBRAAGIMBGLEDGIAEMg0IBhAAGIMBGLEDGIAEMg0IBxAAGIMBGLEDGIAEMhAICBAAGIMBGLEDGIAEGIoFMg0ICRAAGIMBGLEDGIAE0gEIMTM5MmowajeoAgCwAgA/chrome/UTF-8
     *
     *
     * Zeta:
     *   Sodexo: backoffice-app
     *      Corporate: corporate-app
     *         Employees: employee-app
     *
     *   esp: enterprise service provider (Sdx-SPAIN, sdx-italy, etc..)
     *     corporate: Amazon, Accenture
     *       employee:
     *
     *    /esp/{espId}/corporate/{corporateId}/order/{orderId}
     *    /esp/1/corporate/12/order/100
     *
     *    Primary
     *    1, 2, .....     => {uuid1, uuid2, ....}
     *
     *    Primary
     *    uuid1, uuid2, ....
     *
     *    /order?espId=1&corporateId=12&orderId=100 : // multi tenancy
     *
     *    10 orders till now
     *
     *
     *
     * 1. Variables :
     *      1.1 RequestParam:
     *      1.2 PathVariable:
     * 2. JSON data: @RequestBody
     */

    /**
     * Unsafe methods : POST PATCH PUT DELETE
     * Safe methods: GET HEAD OPTIONS
     */

    @PutMapping("/user/{userId}")
    public UserUpdateResponse updateUser(@PathVariable("userId") Integer id, @RequestBody UserUpdateRequest userUpdateRequest){
        User user = this.userService.update(id, userUpdateRequest);
        this.logger.info("user updated: {}", user);
        return UserUpdateResponse.from(user);

    }

    // FE will send something which it has to update
    // FE had to send the data which it doesn't have to update and it was not getting in the GET call
    @PatchMapping("/user/{userId}")
    public UserUpdateResponse updateUser(@PathVariable("userId") Integer id,
                                         @RequestBody UserPatchUpdateRequest userUpdateRequest){
        User user = this.userService.patchUpdate(id, userUpdateRequest);
        this.logger.info("user updated: {}", user);
        return UserUpdateResponse.from(user);

    }

    // Test...
//    @GetMapping("/test")
//    public JSONObject test(@RequestParam("name") String name){
//        JSONObject obj = new JSONObject();
//        obj.put("name", name);
//        return obj;
//    }

//    Map<String, String>
//    JSONObject - from json-simple

    // throws keyboard

    @DeleteMapping("/user/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Integer id) throws IOException {
//        try {
            this.userService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
//        }catch (NotFoundException e){
//            e.printStackTrace();
//            this.logger.error("deleteUser: userId {} not found", id);
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }catch (Exception e){
//            this.logger.error("deleteUser: for userId {}, got an exception", id);
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    // Static methods
    // Instance methods / member functions

    /**
     * ControllerAdvice: Define all the exception --> status code mapping
     *
     *
     */
}
