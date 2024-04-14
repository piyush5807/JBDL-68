package com.example.demoioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Person {

    // com.example.demoioc.Person@1128620c - spring created during application startup (IOC)


    // com.example.demoioc.Person@2e52b39
    // com.example.demoioc.Person@61cf5441

    private static Logger logger = LoggerFactory.getLogger(Person.class);

//    public Person() {
////        int a = 1/0;
//        logger.info("Inside person default: this = {}", this);
//    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        logger.info("Insider person parameterized: this = {}", this);
    }

    private int id;
    private String name;

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
}
