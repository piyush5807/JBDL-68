package com.example.demo_redis.controllers;

import com.example.demo_redis.dto.CreatePersonRequest;
import com.example.demo_redis.model.Person;
import com.example.demo_redis.services.StringValueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class StringValueController {

    @Autowired
    StringValueService stringValueService;

    @PostMapping("/value")
    public Person createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        return this.stringValueService.create(createPersonRequest.to());
    }

    @GetMapping("/value/{id}")
    public Person getPerson(@PathVariable("id") String personId){
        return this.stringValueService.get(personId);
    }

}
