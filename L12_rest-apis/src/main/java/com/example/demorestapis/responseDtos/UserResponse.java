package com.example.demorestapis.responseDtos;

import com.example.demorestapis.models.Gender;
import com.example.demorestapis.models.User;

public class UserResponse {

    /**
     * Understand who all the clients of your API
     * Requirements of those client
     * Who can be future clients // hard to speculate
     */


    private int id;
    private String name;

    private String email;

    private Integer age;

    private Gender gender;

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

    // U1 : {name, email, age} , U2: {name, email, age, gender}
    //


    public UserResponse(int id, String name, String email, Integer age, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public static UserResponse from(User user){
        if(user == null){
            return null;
        }

        UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getAge(), user.getGender());
//        userResponse.age = user.getAge();
//        userResponse.name = user.getName();
//        userResponse.gender = user.getGender();
//        userResponse.id = user.getId();
//        userResponse.email = user.getEmail();

        return userResponse;

    }
}
