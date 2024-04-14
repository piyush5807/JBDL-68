package com.example.demoioc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TestService {

//    TestService(){
//        int a = 1 / 0;
//    }

    public void doSomething(){
        System.out.println("Inside doSomething");
    }

}
