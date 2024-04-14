package com.example.demoioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController // spring boot to create an object
//@Component
public class DemoController {

//    @Autowired // this will get the reference of an object of Person class present in the IOC container
//    private Person person = new Person();
    /**
     * Here the object is created by you, managed by you and not by spring
     */

    @Autowired
    private Person person;

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    DemoController(){
        logger.info("Inside demoController constructor: this = {}", this);
    }

    /**
     * Will the object of demoController be created before the application is started
     * or after the application is started
     *
     *
     * There will be only 1 democontroller object that is created and that too in the beginning
     *
     * @return
     */

    /**
     * IOC : Inversion of control
     *     Instead of you creating an object of a particular class, spring does it for you
     *     1. All the objects that are created by spring will be created before the application startup
     *     2. You need to tell spring for what all classes the objects need to be created
     *     3. Spring will only create the objects for classes that have @Component annotation
     *        on top of them either directly or indirectly
     *     4. Whenever spring creates an object itself, it stores that object in a container known
     *        as IOC container and programmatically it's known as ApplicationContext
     *
     * Dependency Injection (DI)
     *      1. It's the phenomenon using which a class can get the reference of any other dependent class
     *         object from the IOC container
     *
     *         getting the reference from IOC ~ Injecting a dependency in the current class
     *      2. If the object is not present in the IOC container, there cannot be any dependency injection
     *
     * Bean: Something that is managed by Spring (object or property)
     *
     *
     * Tomorrow's Agenda
     * 1. Different type of Bean scopes
     * 2. How to create bean using configuration classes (an object of inbuilt class not our own class)
     * 3. Different types of dependency injection
     * 4. Injecting a value as a dependency
     * 5. Lombok
     *
     * 6. Different types of Annotations and how to read and understand them
     *
     * @return
     */

    @GetMapping("/demo")
    public String demo(){
        Person person = new Person(1, "Abhinav");
        logger.info("person - {}", person);
        return "Hello World!!";
    }

    // com.example.demoioc.Person@2b329bbd
    // com.example.demoioc.Person@2b329bbd
    // com.example.demoioc.Person@2b329bbd
}
