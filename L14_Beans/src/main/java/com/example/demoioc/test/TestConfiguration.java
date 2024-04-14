package com.example.demoioc.test;

import com.example.demoioc.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("prototype")
public class TestConfiguration {

    /**
     * new object inside the constructor, you are tightly coupling testConfiguration and ObjectMapper
     * these objects are not stored in the IOC container and hence cannot be injected, these can only be used with the testConfiguration class
     *
     * @Bean annotation with singleton scope will ensure that no matter how many objects of testConfiguration
     *      are created, only a single objectmapper instance will be there
     */

    private ObjectMapper objectMapper;

    // com.fasterxml.jackson.databind.ObjectMapper@664e5dee
    // com.fasterxml.jackson.databind.ObjectMapper@5a00eb1e
//
    TestConfiguration(){

//        this.objectMapper = new ObjectMapper();
        System.out.println("Inside TestConfiguration: this = " +  this + ", objectMapper = " + this.objectMapper);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * TestConfiguration (Singleton)   &  getOM (Singleton)
     * TestConfiguration (Singleton)   &  getOM (Prototype)
     * TestConfiguration (Prototype)   &  getOM (Prototype)
     * TestConfiguration (Prototype)   &  getOM (Singleton)
     *
     *
     * product - OM
     * order - OM
     * delivery - OM
     * delivery partner - OM
     * payment - OM
     */

    @Bean // @Component that you write on top of class  | we are asking spring to save the reference returned from this function in the IOC container
//    @Scope("prototype")
    public ObjectMapper getOM(){             // static or member ?? member fn => an object of the class

        ObjectMapper mapper = new ObjectMapper(); // we are creating the object ourself
        System.out.println("Inside getObjectMapper: mapper = " + mapper);
        return mapper;
    }


    @Bean // @Component that you write on top of class  | we are asking spring to save the reference returned from this function in the IOC container
    @Scope("prototype")
    public Person getPerson(){             // static or member ?? member fn => an object of the class
        return new Person();
    }



    /**
     * Bean - function level annotation to declare beans that are returned from a function, i.e
     *        those classes that we as a developer cannot modify
     * Component - Class level annotation to declare beans of the classes we as a developer create
     */
}
