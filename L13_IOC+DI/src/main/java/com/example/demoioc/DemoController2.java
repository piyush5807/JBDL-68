package com.example.demoioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {

//    private Person person = new Person();

    private static Logger logger = LoggerFactory.getLogger(DemoController2.class);

    @Autowired
    private Person person;

    @GetMapping("/demo2")
    public String demo2(){
        logger.info("person - {}", this.person);
        return "Hello World!!!";
    }
}
