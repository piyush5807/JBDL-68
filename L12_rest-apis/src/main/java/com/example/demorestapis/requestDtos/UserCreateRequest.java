package com.example.demorestapis.requestDtos;

import com.example.demorestapis.models.Gender;
import com.example.demorestapis.models.User;

import java.util.Date;

// POJO: Plain old java object
public class UserCreateRequest {

    /**
     * email : abc@gmail.com
     * name: ABC
     * gender: MALE
     * age: 10
     * password: abc123
     *
     * UserCreateRequest request = new UserCreateRequest();
     * request.setEmail(email);
     * request.setName()
     */

    private String name;

    private String email;

    private String password;

    private Integer age;

    private Gender gender;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    // cron / scheduler that runs every 5 mins and reads all the users whose data is updated in last 6 mins
    // and pushes the updated data to bigquery



    public User to(){
        User user = new User();
        user.setAge(this.age);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setGender(this.gender);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        return user;
    }

}
