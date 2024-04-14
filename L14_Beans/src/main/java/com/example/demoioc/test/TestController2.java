package com.example.demoioc.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @Autowired
    TestConfiguration testConfiguration; // t2 => getOM() => Bean of OM has been created

//    @Autowired
//    ObjectMapper objectMapper;

    // ObjectMapper@5880

    @GetMapping("/test2")
    public String func() throws JsonProcessingException {
        ObjectMapper o1 = this.testConfiguration.getOM();
        ObjectMapper o2 = this.testConfiguration.getOM();
        ObjectMapper o3 = this.testConfiguration.getOM();
        ObjectMapper o4 = this.testConfiguration.getOM();
        ObjectMapper o5 = this.testConfiguration.getOM();
        ObjectMapper o6 = this.testConfiguration.getOM();

        return "Hello world";
    }

    public void func2(){

        ObjectMapper o = new ObjectMapper();
        ObjectMapper o7 = new ObjectMapper();
        ObjectMapper o8 = new ObjectMapper();
        ObjectMapper o9 = new ObjectMapper();
        ObjectMapper o10 = new ObjectMapper();

    }
}
