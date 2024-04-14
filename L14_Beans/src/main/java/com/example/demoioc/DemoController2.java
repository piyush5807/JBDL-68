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

    @Autowired // this will attach the reference of Person's object stored in IOC
    private Person person;

    @GetMapping("/demo2")
    public String demo2(){
        logger.info("inside demo2, person - {}", person);
        this.person.setId(30);
        this.person.setName("DEF");
        logger.info("inside demo2, after updating person - {}", person);
        return "Hello World!!!";
    }

    /**
     * Inside person default: this = com.example.demoioc.Person@74aa9c72 (DC)
     * Inside person default: this = com.example.demoioc.Person@7c447c76 (DC2)
     *
     *
     * com.example.demoioc.Person@74aa9c72
     * com.example.demoioc.Person@74aa9c72
     * com.example.demoioc.Person@74aa9c72
     *
     *
     * com.example.demoioc.Person@7c447c76
     */

    /**
     * Bean_name :  Reference of the object
     * demoIocApplication : xa6f12
     * person_demoController: ref1
     * person_demoController2: ref2
     *
     *
     */
}
